package textGame;

public class Player extends Character{
    public int health = 100;
    public int level = 1;
    public int xp = 0;

    public Player(Scene scene) {
        this.scene = scene;
    }
    /// move to connected scene 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public void move(int direction) {
        Position targetPosition = new Position(this.scene.position);
        if (direction == 0) {
            targetPosition.y++;
        }
        else if (direction == 1) {
            targetPosition.x++;
        }
        else if (direction == 2) {
            targetPosition.y--;
        }
        else if (direction == 3) {
            targetPosition.x--;
        }
        Scene targetScene = Scene.getByPosition(targetPosition);
        if (targetScene != null) {
            scene = targetScene;
        }
        else {
            scene = new Scene(scene, direction);
        }
    }
}

