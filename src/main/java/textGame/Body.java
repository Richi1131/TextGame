package textGame;

import java.util.Random;

public class Body implements Attackable {
    protected Head head;
    protected Torso torso;
    protected Limb[] limbs;

    @Override
    public boolean getAttacked(int damage) {
        Random rand = new Random();
        int hitRoll = rand.nextInt(0, limbs.length + 6);
        if (hitRoll < limbs.length) {
            return limbs[hitRoll].getAttacked(damage);
        }
        else if (hitRoll == limbs.length) {
            return head.getAttacked(damage);
        }
        else {
            return torso.getAttacked(damage);
        }
    }
}

