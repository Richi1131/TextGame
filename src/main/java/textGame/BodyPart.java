package textGame;

public abstract class BodyPart implements Die, Attackable {
    private int health = 100;
    private Body body;
    public int getHealth() {
        return health;
    }
    public Body getBody() {
        return body;
    }
    public BodyPart(Body body) {
        this.body = body;
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
        this.damage(damage);
        return true;
    }
}
