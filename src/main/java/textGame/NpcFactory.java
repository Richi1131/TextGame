package textGame;

import java.util.Random;

public class NpcFactory extends GameObjectCsvFactory {
    @Override
    public GameObject create(String[] npcInformation) {
        Npc npc = new Npc();

        npc.setName(npcInformation[0]);
        npc.setDescription(npcInformation[1]);
        npc.setDamage(Integer.parseInt(npcInformation[2]));

        npc.addRandomLoot();

        return npc;
    }

    @Override
    public String getCsvPath() {
        return "src/main/resources/npcs.csv";
    }
}
