package textGame;

import java.util.Random;

public class Body extends GameObject implements Die, Attackable {
    protected Head head;
    protected Torso torso;
    protected Limb[] limbs;
    public BodyPart[] getBodyParts() {
        BodyPart[] bodyParts = new BodyPart[limbs.length + 2];
        bodyParts[0] = head;
        bodyParts[1] = torso;
        System.arraycopy(limbs, 0, bodyParts, 2, limbs.length);
        return bodyParts;
    }

    private Character character;

    public Character getCharacter() {
        return character;
    }

    public Body (Character character) {
        this.character = character;
        setName(character + "'s_body");
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

    @Override
    public boolean isDead() {
        return character.isDead();
    }

    public GameObject getBodyPartByName(String name) {
        for (BodyPart bodyPart : getBodyParts()) {
            if (bodyPart != null && bodyPart.getName().equals(name)) {
                return bodyPart;
            }
        }
        return null;
    }
}

