package textGame

import kotlin.jvm.internal.ClassReference

class HealingItemFactory : GameObjectFactory() {
    override fun create(gameObjectInformation: Array<String>): GameObject {
        val healingItem = HealingItem()

        healingItem.setName(gameObjectInformation[0])
        healingItem.setDescription(gameObjectInformation[1])
        healingItem.healAmount = gameObjectInformation[2].toInt()
        healingItem.setUses(gameObjectInformation[3].toInt())

        return healingItem
    }

    override fun getCsvPath(): String {
        return "src/main/resources/healing_items.csv"
    }
}