package textGame;

public class Weapon extends Item implements Equipable {
    private int damage;
    private int durability;

    private String[] slots = {"Hand"};
    @Override
    public void inspect() {
        System.out.println("Inspected Item:");
        System.out.println("    Name: " + getName());
        System.out.println("    Description: " + getDescription());
        System.out.println("    Damage: " + damage);
        System.out.println("    Durability: " + durability);
    }

    @Override
    public String[] getSlots() {
        return slots;
    }
}
