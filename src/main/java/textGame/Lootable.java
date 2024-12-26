package textGame;

public interface Lootable {
    public Inventory getInventory();
    default public Item loot(String name) {
        Inventory inventory = getInventory();
        Item item = inventory.getItemByName(name);
        if (item != null) {
            inventory.removeItem(item);
            System.out.println(name + " was looted from " + this + ".");
            return item;
        }
        else {
            System.out.println(name + " not found in " + this + ".");
            return null;
        }
    }
    default public void addRandomLoot() {
        getInventory().addItem(FactoryManager.generateRandomLoot());
    }
}
