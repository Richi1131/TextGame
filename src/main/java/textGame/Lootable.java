package textGame;

public interface Lootable {
    public Inventory getInventory();
    default public Item loot(String name) {
        Inventory inventory = getInventory();
        Item item = inventory.getItemByName(name);
        inventory.removeItem(item);
        return item;
    }
}
