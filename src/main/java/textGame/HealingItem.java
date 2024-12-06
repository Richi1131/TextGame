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
        else if (gameObject instanceof Character character) {
            System.out.println("What part of " + character + " do you want to heal?");
            System.out.println("The available Options are: ");
            System.out.println();
            BodyPart[] bodyParts = character.body.getBodyParts();
            for (int i = 0; i < bodyParts.length; i++) {
                System.out.println(i+1 + ". "+ bodyParts[i]);
            }
            return false;
        }
        else {
            return false;
        }
    }
}
