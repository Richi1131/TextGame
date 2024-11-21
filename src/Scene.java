public class Scene {
    /// scenes connected in space 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public Scene[] linkedScenes = new Scene[4];
    public Encounter encounter;
    public Action[] possibleActions;
    public static Action actionMoveForwards = new Action("Move down the road.");
    public static Action actionMoveBack = new Action("Go back.");
    /// Constructor for entering a scene from another scene
    Scene() {
        generateEncounter();
        generatePossibleActions();
    }
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
