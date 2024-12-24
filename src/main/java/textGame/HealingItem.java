package textGame;

public class HealingItem extends Item implements UsableOnGameObject {
    private int healAmount;
    private int uses;
    public void setUses(int uses) {
        this.uses = uses;
    }
    public int getHealAmount() {
        return healAmount;
    }
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public HealingItem() {
        setName("improperly_constructed_healing_item");
    }
    @Override
    public boolean useOn(GameObject gameObject) {
        // TODO: move 'uses' logic to Usable on game Object interface
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

    @Override
    public void inspect() {
        System.out.println("Inspected Item:");
        System.out.println("    Name: " + getName());
        System.out.println("    Descripion: " + getDescription());
        System.out.println("    Heal Amount: " + healAmount);
        System.out.println("    Remaining Uses: " + uses);
    }
}
