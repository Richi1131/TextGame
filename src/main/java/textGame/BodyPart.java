package textGame;

public abstract class BodyPart extends GameObject implements Die, Health, Attackable {
    private int maxHealth = 100;
    private int health = 100;
    private Body body;
    @Override
    public int getMaxHealth() {
        return maxHealth;
    }
    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public void heal(int amount) {
        System.out.println("Healed " + getBody().getCharacter().getName() + "'s " + getName() + " by " + Math.min((getMaxHealth() - getHealth()), amount));
        setHealth(Math.min(getMaxHealth(), getHealth() + amount));
        System.out.println("New " + getName() + " Health is " + getHealth());
    }
    public Body getBody() {
        return body;
    }
    public BodyPart(Body body, String name) {
        this.body = body;
        setName(name);
    }
    public void damage(int damage) {
        if (health > damage) {
            health = health - damage;
        }
        else {
            health = 0;
            onDeath();
        }
    }

    @Override
    public boolean getAttacked(int damage) {
        System.out.println(this.body.getCharacter() + "'s " + this + " was hit for " + damage + " damage.");
        this.damage(damage);
        return true;
    }
    public String toString() {
        return this.getName();
    }
}
