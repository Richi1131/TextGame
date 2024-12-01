package textGame;

import java.util.Random;

public class Body implements Die, Attackable {
    protected Head head;
    protected Torso torso;
    protected Limb[] limbs;

    private Character character;

    public Character getCharacter() {
        return character;
    }

    public Body (Character character) {
        this.character = character;
    }
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

    @Override
    public void onDeath() {
        character.onDeath();
    }
}

