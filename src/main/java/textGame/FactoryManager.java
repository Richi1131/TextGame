package textGame;

import java.util.Random;

public class FactoryManager {
    public static Item generateRandomLoot() {
        GameObjectCsvFactory[] factories = {new HealingItemFactory()};
        Random rand = new Random();
        int typeRoll = rand.nextInt(0, factories.length);
        GameObjectCsvFactory factory = factories[typeRoll];
        // todo: roll for rarety?
        return (Item) factory.createRandomFromCsv();
    }
    public static Npc generateRandomNpc() {
        NpcFactory factory = new NpcFactory();
        return (Npc) factory.createRandomFromCsv();
    }
    public static Body generateHumanoidBody() {
        BodyFactory factory = new HumanoidBodyFactory();
        return factory.create();
    }
}
