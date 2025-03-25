package textGame

import java.util.*

class Scene internal constructor() : GameObject(), Searchable, Lootable {
    companion object {
        private var counter = 0
        private val sceneHashtable = Hashtable<Position, Scene>()
        fun getByPosition(position: Position?): Scene? {
            return sceneHashtable[position]
        }

        fun getByPosition(x: Int, y: Int): Scene? {
            return getByPosition(Position(x, y))
        }

        fun newRandomScene(position: Position): Scene {
            val scene = FactoryManager.generateRandomScene()
            scene.position = Position(position)
            sceneHashtable[scene.position] = scene
            return scene
        }
    }
    private val danger = 0
    private val value = 0
    var player: Player? = null
    private val inventory = Inventory(3)
    var position: Position? = null
        private set
    var npcs: Array<Npc> = emptyArray()
        private set

    /** scenes connected to current scene in space 0 -> front, 1 -> right, 2 -> back, 3 -> left */
    private val openExits = arrayOf(true, true, true, true)

    fun addNpc(npc: Npc) {
        npcs += npc
        npc.scene = this
    }

    fun isExitOpen(direction: Int): Boolean {
        return openExits[direction]
    }

    fun getGameObjectByName(name: String): GameObject? {
        if (name == player!!.getName() || name == "self") {
            return player
        }
        for (npc in npcs) {
            if (npc.getName() == name) {
                return npc
            }
        }
        val item = inventory.getItemByName(name)
        if (item != null) {
            return item
        }
        return null
    }

    init {
        counter++
    }

    override fun toString(): String {
        return this.getName()
    }

    fun removeNpc(npc: Npc) {
        npcs = npcs.filter{it != npc}.toTypedArray()
    }

    fun getNpc(name: String): Npc? {
        return npcs.find{it.getName() == name}
    }

    override fun getInventory(): Inventory {
        return inventory
    }
    fun getMapDepiction(): String? {
        return "X"
    }
}