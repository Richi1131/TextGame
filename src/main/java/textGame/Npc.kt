package textGame

class Npc : Character(), Attack, Searchable, Lootable {
    private var damage = 0
    private val inventory = Inventory(3)

    fun setDamage(damage: Int) {
        this.damage = damage
    }

    override fun onDeath() {
        if (isAlive) {
            println(getName() + " has died.")
            setName(getName() + " (dead)")
            isAlive = false
        } else {
            println(getName() + " is already dead.")
        }
    }

    override fun getDamage(): Int {
        return damage
    }

    override fun toString(): String {
        return getName()
    }

    fun takeTurn() {
        attack(scene.player)
    }

    override fun getInventory(): Inventory {
        return inventory
    }
}