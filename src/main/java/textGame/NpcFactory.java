package textGame;

import java.util.Random;

public class NpcFactory {
    public Npc create(String[] npcInformation) {
        Npc npc = new Npc();

        npc.setName(npcInformation[0]);
        npc.setDescription(npcInformation[1]);
        npc.setDamage(Integer.parseInt(npcInformation[2]));

        npc.addRandomLoot();

        return npc;
    }
    public String getCsvPath(){
        return "src/main/resources/npcs.csv";
    }
    public Npc createFromCsv(int lineNumber) {
        String npcLine = Utility.readCsvLine(getCsvPath(), lineNumber);
        String[] npcInformation = npcLine.split(",");
        return create(npcInformation);
    }
    public Npc createRandomFromCsv() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength(getCsvPath());
        return createFromCsv(rand.nextInt(lowerBound, upperBound));
    }
}
