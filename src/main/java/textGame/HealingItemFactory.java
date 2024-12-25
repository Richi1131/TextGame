package textGame;

public class HealingItemFactory extends GameObjectCsvFactory {

    @Override
    public Item create(String[] itemInformation) {
        HealingItem healingItem = new HealingItem();

        healingItem.setName(itemInformation[0]);
        healingItem.setDescription(itemInformation[1]);
        healingItem.setHealAmount(Integer.parseInt(itemInformation[2]));
        healingItem.setUses(Integer.parseInt(itemInformation[3]));

        return healingItem;
    }

    @Override
    public String getCsvPath() {
        return "src/main/resources/healing_items.csv";
    }
}
