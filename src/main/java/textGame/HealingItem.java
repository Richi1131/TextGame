package textGame;

public class HealingItem extends Item implements UsableOnGameObject {
    private int healAmount; // TODO: remove hardcoding
    private int uses;
    public int getHealAmount() {
        return healAmount;
    }
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
    public static HealingItem generateFromCSV(int lineNumber) {
        String itemLine = Utility.readCsvLine("src/main/resources/healing_items.csv", lineNumber);
        String[] itemInformation = itemLine.split(";");

        HealingItem healingItem = new HealingItem();
        healingItem.setName(itemInformation[0]);
        healingItem.setDescription(itemInformation[1]);
        healingItem.setHealAmount(Integer.parseInt(itemInformation[2]));
        healingItem.uses = Integer.parseInt(itemInformation[3]);

        return healingItem;
    }
    public HealingItem() {
        setName("bandage"); // TODO: remove hardcoding
    }
    @Override
    public boolean useOn(GameObject gameObject) {
        // TODO: move uses logic to Usable on game Object interface
        if (uses < 1) {
            System.out.println(getName() + " is used up.");
            return false;
        }
        if (gameObject instanceof Health health) {
            health.heal(getHealAmount());
            uses--;
            return true;
        }
        else {
            System.out.println("You cannot heal " + gameObject + ".");
            return false;
        }
    }
}
