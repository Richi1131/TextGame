package textGame;

import java.util.Hashtable;
import java.util.Random;

public class Scene {
    private static int counter = 0;
    private static Hashtable<Position, Scene> sceneHashtable = new Hashtable<Position, Scene>();
    private String name;
    private String description;
    private int danger;
    private int value;
    private Position position;
    /// scenes connected to current scene in space 0 -> front, 1 -> right, 2 -> back, 3 -> left
    private Boolean[] openExits = {true, true, true, true};
    private Encounter encounter;
    private Action[] possibleActions;
    private static Action actionMoveForwards = new Action("Move down the road.");
    private static Action actionMoveBack = new Action("Go back.");

    public static Scene getByPosition(Position position) {
        return sceneHashtable.get(position);
    }
    public static Scene getByPosition(int x, int y) {
        return getByPosition(new Position(x, y));
    }

    public String getDescription() {
        return this.description;
    }
    public Position getPosition() {
        return this.position;
    }
    public Npc getNpc() {
        return encounter.npc;
    }
    public boolean isExitOpen(int direction) {
        return openExits[direction];
    }
    private Scene() {
        generateFromRandomLocation();
        generateRandomEncounter();
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
        return this.name;
    }
    public void generateFromLocationsCSV(int lineNumber) {
        String locationLine = Utility.readCsvLine("src/main/resources/locations.csv", lineNumber);
        String[] locationInformation = locationLine.split(",");

        this.name = locationInformation[0];
        this.description = locationInformation[1];
        this.danger = Integer.parseInt(locationInformation[2]);
        this.value = Integer.parseInt(locationInformation[3]);
    }
    public void generateFromRandomLocation() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength("src/main/resources/locations.csv");
        generateFromLocationsCSV(rand.nextInt(lowerBound, upperBound));
    }
    public void generateRandomEncounter() {
        encounter = new Encounter();
    }
    private void generatePossibleActions() {
        possibleActions = new Action[2];
        possibleActions[0] = actionMoveForwards;
        possibleActions[1] = actionMoveBack;
    }

}
