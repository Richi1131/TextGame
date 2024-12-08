package textGame;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Scene extends GameObject implements Searchable {
    private static int counter = 0;
    private static Hashtable<Position, Scene> sceneHashtable = new Hashtable<Position, Scene>();
    private Player player;
    private Inventory inventory = new Inventory();
    private Position position;
    private Npc[] npcs = new Npc[0];

    /// scenes connected to current scene in space 0 -> front, 1 -> right, 2 -> back, 3 -> left
    private Boolean[] openExits = {true, true, true, true};
    private Action[] possibleActions;
    private static Action actionMoveForwards = new Action("Move down the road.");
    private static Action actionMoveBack = new Action("Go back.");

    public static Scene getByPosition(Position position) {
        return sceneHashtable.get(position);
    }
    public static Scene getByPosition(int x, int y) {
        return getByPosition(new Position(x, y));
    }
    public Position getPosition() {
        return this.position;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void addRandomNpc() {
        addNpc(new Npc(this));
    }
    public void addNpc(Npc npc) {
        Npc[] newNpcs = new Npc[npcs.length + 1];
        for (int i = 0; i < npcs.length; i++) {
            newNpcs[i] = npcs[i];
        }
        newNpcs[newNpcs.length-1] = npc;
        npcs = newNpcs;
    }
    public Npc[] getNpcs() {
        return npcs;
    }
    public boolean isExitOpen(int direction) {
        return openExits[direction];
    }
    public GameObject getGameObjectByName(String name) {
        if (name.equals(player.getName()) || name.equals("self")) {
            return player;
        }
        for (Npc npc : npcs) {
            if (npc.getName().equals(name)) {
                return npc;
            }
        }
        return null;
        /*for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }*/
    }
    private Scene() {
        generateFromRandomLocation();
        addRandomNpc();
        counter++;
    }
    Scene(Position position) {
        this();
        this.position = new Position(position);
        Scene.sceneHashtable.put(this.position, this);
    }
    /// Constructor for entering a scene from another scene
    Scene(Scene originScene, int direction) {
        this();
        position = Utility.calculateNewPosition(originScene.position, direction);
        Scene.sceneHashtable.put(position, this);
    }
    public String toString() {
        return this.getName();
    }
    public void generateFromLocationsCSV(int lineNumber) {
        String locationLine = Utility.readCsvLine("src/main/resources/locations.csv", lineNumber);
        String[] locationInformation = locationLine.split(",");

        setName(locationInformation[0]);
        setDescription(locationInformation[1]);
        //this.danger = Integer.parseInt(locationInformation[2]);
        //this.value = Integer.parseInt(locationInformation[3]);
    }
    public void generateFromRandomLocation() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength("src/main/resources/locations.csv");
        generateFromLocationsCSV(rand.nextInt(lowerBound, upperBound));
    }
    //public void generateRandomEncounter() {
    //    encounter = new Encounter(this);
    //}
    private void generatePossibleActions() {
        possibleActions = new Action[2];
        possibleActions[0] = actionMoveForwards;
        possibleActions[1] = actionMoveBack;
    }

    public void removeNpc(Npc npc) {
        if (npcs.length == 0) {
            return;
        }
        if (npcs.length == 1) {
            if (npcs[0] == npc) {
                npcs = new Npc[0];
                return;
            }
        }
        Npc[] newNpcs = new Npc[npcs.length - 1];
        int offset = 0;
        for (int i = 0; i < npcs.length - 1; i++) {
            if (npc == npcs[i] && offset == 0) {
                offset++;
            }
            newNpcs[i] = npcs[i+offset];
        }
        if (offset == 1) {
            newNpcs[newNpcs.length - 1] = npc;
            npcs = newNpcs;
        }
    }

    public Npc getNpc(String name) {
        for (Npc npc : npcs) {
            if (npc.getName().equals(name)) {
                return npc;
            }
        }
        return null;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
