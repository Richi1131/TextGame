package textGame;

import java.util.Random;

public abstract class Character extends GameObject implements Attackable, Die, Health {
    private Scene scene;
    protected Body body;
    private Inventory inventory = new Inventory(3);
    protected boolean isAlive = true;

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public Scene getScene() {
        return scene;
    }
    public Inventory getInventory() {
        return inventory;
    }
    @Override
    public boolean isDead() {
        return !isAlive;
    }
    public Character() {
        // todo: factory for character creation
        body = FactoryManager.generateHumanoidBody();
        body.setCharacter(this);
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
    public int getMaxHealth() {
        int sumMaxHealth = 0;
        for (BodyPart bodyPart : body.getBodyParts()) {
            sumMaxHealth = sumMaxHealth + bodyPart.getMaxHealth();
        }
        return sumMaxHealth;
    }
    @Override
    public void setMaxHealth(int health) {

    }
    @Override
    public int getHealth() {
        int sumHealth = 0;
        for (BodyPart bodyPart : body.getBodyParts()) {
            sumHealth = sumHealth + bodyPart.getHealth();
        }
        return sumHealth;
    }
    @Override
    public void setHealth(int health) {

    }
    @Override
    public void heal(int amount) {
        for (BodyPart bodyPart : body.getBodyParts()) {
            if (bodyPart.getHealth() < bodyPart.getMaxHealth()) {
                bodyPart.heal(amount);
                return;
            }
        }
    }
    @Override
    public String toString() {
        return this.getName();
    }

}
