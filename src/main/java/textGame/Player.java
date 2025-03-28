package textGame;

public class Player extends Character implements Attack, Loot {
    private int damage = 100;

    public Player(Scene scene) {
        setScene(scene);
        setName("player");
        setDescription("You.");
    }
    /// move to connected scene 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public void move(int direction) {
        if (!getScene().isExitOpen(direction)) {
            System.out.println("Can't exit in this direction.");
            return;
        }
        Position targetPosition = Utility.Companion.calculateNewPosition(this.getScene().getPosition(), direction);
        Scene targetScene = Scene.Companion.getByPosition(targetPosition);
        getScene().setPlayer(null);
        if (targetScene != null) {
            setScene(targetScene);
        }
        else {
            Position newPosition = Utility.Companion.calculateNewPosition(getScene().getPosition(), direction);
            setScene(Scene.Companion.newRandomScene(newPosition));
        }
        getScene().setPlayer(this);
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

