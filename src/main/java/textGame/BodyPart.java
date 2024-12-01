package textGame;

public abstract class BodyPart implements Die, Attackable {
    private int health = 100;
    private Body body;
    private String name;
    public int getHealth() {
        return health;
    }
    public Body getBody() {
        return body;
    }
    public BodyPart(Body body, String name) {
        this.body = body;
        this.name = name;
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
        return this.name;
    }
}
