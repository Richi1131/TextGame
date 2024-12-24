package textGame;

import java.util.Random;

public class FactoryManager {
    public static Item generateRandomLoot() {
        ItemFactory[] factories = {new HealingItemFactory()};
        Random rand = new Random();
        int typeRoll = rand.nextInt(0, factories.length);
        ItemFactory factory = factories[typeRoll];
        // todo: roll for rarety?
        return factory.createRandomFromCsv();
    }
    public static Npc generateRandomNpc() {
        NpcFactory factory = new NpcFactory();
        return factory.createRandomFromCsv();
    }
}
