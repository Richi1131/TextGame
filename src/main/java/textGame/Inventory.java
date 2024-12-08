package textGame;

public class Inventory {
    private Item[] items = new Item[3];
    public Item[] getItems() {
        return items;
    }
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    public boolean addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }
}
