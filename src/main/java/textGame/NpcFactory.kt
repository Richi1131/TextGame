package textGame

class NpcFactory : GameObjectCsvFactory() {
    override fun create(npcInformation: Array<String>): GameObject {
        val npc = Npc()

        npc.setName(npcInformation[0])
        npc.setDescription(npcInformation[1])
        npc.damage = npcInformation[2].toInt()

        npc.addRandomLoot()

        return npc
    }

    override fun getCsvPath(): String {
        return "src/main/resources/npcs.csv"
    }
}