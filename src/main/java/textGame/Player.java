package textGame;

public class Player extends Character implements Attack {
    private int damage = 100;

    public Player(Scene scene) {
        super(scene);
        setName("player");
        setDescription("You");
    }
    /// move to connected scene 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public void move(int direction) {
        if (!scene.isExitOpen(direction)) {
            System.out.println("Can't exit in this direction.");
            return;
        }
        Position targetPosition = Utility.calculateNewPosition(this.scene.getPosition(), direction);
        Scene targetScene = Scene.getByPosition(targetPosition);
        scene.setPlayer(null);
        if (targetScene != null) {
            scene = targetScene;
        }
        else {
            scene = new Scene(scene, direction);
        }
        scene.setPlayer(this);
    }
    @Override
    public void onDeath() {
        App.endGame();
    }


    @Override
    public int getDamage() {
        return damage;
    }
}

