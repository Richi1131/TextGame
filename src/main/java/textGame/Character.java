package textGame;

import java.util.Random;

public abstract class Character extends GameObject implements Attackable, Die {
    public Scene scene;
    protected HumanoidBody body;

    public Character(Scene scene) {
        this.scene = scene;
        body = new HumanoidBody(this);
    }
    @Override
    public boolean getAttacked(int damage) {
        // TODO: evasion / block implementation
        Random rand = new Random();
        int hitRoll = rand.nextInt(0, 10);
        if (hitRoll > 1) {
            return body.getAttacked(damage);
        }
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
