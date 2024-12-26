package textGame

class HealingItem : Item(), UsableOnGameObject, Usable, Inspectable {
    var healAmount: Int = 0
    private var uses = 0
    fun setUses(uses: Int) {
        this.uses = uses
    }

    init {
        setName("improperly_constructed_healing_item")
    }

    override fun useOn(gameObject: GameObject): Boolean {
        // TODO: move 'uses' logic to Usable on game Object interface
        if (uses < 1) {
            println(getName() + " is used up.")
            return false
        }
        if (gameObject is Health) {
            gameObject.heal(healAmount)
            uses--
            return true
        } else {
            println("You cannot heal $gameObject.")
            return false
        }
    }

    override fun getAttributes(): Array<String> {
        var output = super.getAttributes()

        output += "Heal Amount: $healAmount"
        output += "Remaining Uses: $uses"

        return output
    }

    override fun use(): Boolean {
        return useOn(App.player)
    }
}