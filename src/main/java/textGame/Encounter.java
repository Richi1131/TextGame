package textGame;

public class Encounter {
    public Npc npc;

    public void removeNpc() {
        npc = null;
    }

    public void generateRandomEncounter() {
        this.npc = new Npc(this);
    }
    public Encounter() {
        generateRandomEncounter();
    }
}
