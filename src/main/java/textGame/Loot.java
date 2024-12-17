package textGame;

public interface Loot {
    public abstract Inventory getInventory();
    default public boolean loot(Lootable lootable, String targetName) {
        Inventory inventory = getInventory();
        System.out.println(this + " tries to loot " + targetName + " from " + lootable + ".");
        if (!inventory.isFull()) {
            return inventory.addItem(lootable.loot(targetName));
        }
        System.out.println(this + "'s inventory is full.");
        return false;
    }
}
