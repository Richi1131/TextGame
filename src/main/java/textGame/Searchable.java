package textGame;

public interface Searchable {
    public Inventory getInventory();
    default public void search() {
        Inventory inventory = getInventory();
        boolean empty = true;
        for (Item item : inventory.getItems()) {
            if (item != null) {
                empty = false;
                System.out.println("Found: " + item.getName());
            }
        }
        if (empty) {
            System.out.println("There is nothing to be found here.");
        }
    }
}
