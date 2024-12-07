package textGame;

public class HealingItem extends Item implements UsableOnGameObject {
    private int healAmount = 100; // TODO: remove hardcoding
    public int getHealAmount() {
        return healAmount;
    }
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
    public HealingItem() {
        setName("bandage"); // TODO: remove hardcoding
    }
    @Override
    public boolean useOn(GameObject gameObject) {
        if (gameObject instanceof Health health) {
            health.heal(getHealAmount());
            return true;
        }
        else {
            System.out.println("You cannot heal " + gameObject + ".");
            return false;
        }
    }
}
