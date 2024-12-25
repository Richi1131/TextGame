package textGame;

public class Npc extends Character implements Attack, Searchable, Lootable {
    private int damage;
    private Inventory inventory = new Inventory();

    public void setDamage(int damage) {
        this.damage = damage;
    }
    @Override
    public void onDeath() {
        if (isAlive) {
            System.out.println(getName() + " has died.");
            setName(getName() + " (dead)");
            isAlive = false;
        }
        else {
            System.out.println(getName() + " is already dead.");
        }
    }
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getName();
    }
    public void takeTurn() {
        attack(getScene().getPlayer());
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
