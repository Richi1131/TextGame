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
    public boolean removeItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i] = null;
                return true;
            }
        }
        return false;
    }
    public boolean isFull() {
        boolean isFull = true;
        for (Item item : items) {
            if (item == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public String toString() {
        String output = "( ";
        for (int i = 0; i < items.length; i++) {
            output = output + items[i] + " ";
        }
        output = output + ")";
        return output;
    }
}
