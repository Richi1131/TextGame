package textGame;

import java.util.Hashtable;

public class Scene {
    public static int counter = 0;
    public static Hashtable<Position, Scene> sceneHashtable = new Hashtable<Position, Scene>();
    public String name;
    public Position position;
    /// scenes connected to current scene in space 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public Boolean[] openExits = {true, true, true, true};
    public Encounter encounter;
    public Action[] possibleActions;
    public static Action actionMoveForwards = new Action("Move down the road.");
    public static Action actionMoveBack = new Action("Go back.");

    public static Scene getByPosition(Position position) {
        return sceneHashtable.get(position);
    }
    public static Scene getByPosition(int x, int y) {
        return getByPosition(new Position(x, y));
    }
    Scene() {
        generateEncounter();
        generatePossibleActions();
        this.name = String.valueOf(counter);
        position = new Position(0, 0);
        counter++;
    }
    /// Constructor for entering a scene from another scene
    Scene(Scene originScene, int direction) {
        this();
        position = new Position(originScene.position);
        if (direction == 0) {
            position.y++;
        }
        else if (direction == 1) {
            position.x++;
        }
        else if (direction == 2) {
            position.y--;
        }
        else if (direction == 3) {
            position.x--;
        }
        Scene.sceneHashtable.put(position, this);
    }

    public void generateEncounter() {
        encounter = new Encounter();
    }
    private void generatePossibleActions() {
        possibleActions = new Action[2];
        possibleActions[0] = actionMoveForwards;
        possibleActions[1] = actionMoveBack;
    }

}
