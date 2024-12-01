package textGame;

public class BodyPart implements Attackable {
    private int health = 100;
    public int getHealth() {
        return health;
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
    public void onDeath() {
        return;
    }

    @Override
    public boolean getAttacked(int damage) {
        this.damage(damage);
        return true;
    }
}
