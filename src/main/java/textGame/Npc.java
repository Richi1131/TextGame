package textGame;

import java.util.List;
import java.util.Random;

public class Npc extends Character implements Attack, Die {
    private int damage;

    public Npc(Scene scene) {
        super(scene);
        generateRandomNpc();
    }
    @Override
    public void onDeath() {
        System.out.println(getName() + " has died.");
        scene.removeNpc(this);
    }
    public void generateRandomNpc() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength("src/main/resources/locations.csv");
        generateFromNpcsCSV(rand.nextInt(lowerBound, upperBound));
    }

    private void generateFromNpcsCSV(int lineNumber) {
        String locationLine = Utility.readCsvLine("src/main/resources/npcs.csv", lineNumber);
        String[] locationInformation = locationLine.split(",");

        setName(locationInformation[0]);
        setDescription(locationInformation[1]);
        this.damage = Integer.parseInt(locationInformation[2]);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getName();
    }
    public void takeTurn() {
        attack(scene.getPlayer());
    }
}
