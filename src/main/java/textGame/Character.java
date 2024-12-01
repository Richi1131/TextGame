package textGame;

import java.util.Random;

public abstract class Character implements Attackable, Die {
    public String name;
    public Scene scene;
    protected HumanoidBody body;

    public Character() {
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
}
