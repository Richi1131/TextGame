package textGame;

public class Scene {
    public static int counter = 0;
    public String name;
    /// scenes connected to current scene in space 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public Scene[] linkedScenes = new Scene[4];
    public Encounter encounter;
    public Action[] possibleActions;
    public static Action actionMoveForwards = new Action("Move down the road.");
    public static Action actionMoveBack = new Action("Go back.");
    Scene() {
        generateEncounter();
        generatePossibleActions();
        this.name = String.valueOf(counter);
        counter++;
    }
    /// Constructor for entering a scene from another scene
    Scene(Scene enteringFrom) {
        this();
        linkedScenes[2] = enteringFrom;
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
