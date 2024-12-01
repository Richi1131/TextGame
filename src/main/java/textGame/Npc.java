package textGame;

import java.util.Random;

public class Npc extends Character implements Attack, Die {
    private Encounter encounter;
    private String name;
    private String description;
    private int damage;

    public Npc(Encounter encounter) {
        this.encounter = encounter;
        generateRandomNpc();
    }
    @Override
    public void onDeath() {
        System.out.println(name + " has died.");
        encounter.removeNpc();
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

        this.name = locationInformation[0];
        this.description = locationInformation[1];
        this.damage = Integer.parseInt(locationInformation[2]);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return name;
    }
}
