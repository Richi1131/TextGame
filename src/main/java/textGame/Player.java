package textGame;

public class Player {
    public int health = 100;
    public int level = 1;
    public int xp = 0;
    public Scene scene;

    public Player(Scene scene) {
        this.scene = scene;
    }
    /// move to connected scene 0 -> front, 1 -> right, 2 -> back, 3 -> left
    public void move(int direction) {
        if (scene.linkedScenes[direction] != null) {
            scene = scene.linkedScenes[direction];
        }
        else {
            System.out.println("Cant leave there");
        }
    }
}

