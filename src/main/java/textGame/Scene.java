package textGame;

import java.util.Hashtable;

public class Scene {
    private static int counter = 0;
    private static Hashtable<Position, Scene> sceneHashtable = new Hashtable<Position, Scene>();
    private String name;
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
    public Position getPosition() {
        return this.position;
    }
    Scene() {
        generateEncounter();
        generatePossibleActions();
        this.name = String.valueOf(counter);
        position = new Position(0, 0);
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
        position = Calculator.calculateNewPosition(originScene.position, direction);
        Scene.sceneHashtable.put(position, this);
    }
    public String toString() {
        return this.name;
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
