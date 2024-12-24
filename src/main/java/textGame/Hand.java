package textGame;

import java.util.Arrays;

public class Hand extends BodyPart {
    private Arm arm;
    public Hand(Arm arm) {
        super(arm.getBody(), arm.getName() + "_hand");
    }

    @Override
    public void onDeath() {
        System.out.println("Hand died.");
    }

    private Equipable equipment;
    public Equipable getEquipment() {
        return equipment;
    }
    public boolean setEquipment(Equipable equipable) {
        if (equipment != null) {
            return false;
        }
        if (Arrays.asList(equipable.getSlots()).contains("hand")) {
            this.equipment = equipable;
            return true;
        }
        return false;
    }
}
