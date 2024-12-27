package textGame

abstract class PlayerCommand (
    val keywords: Array<String>
) {
    abstract fun execute(args: Array<String>): Boolean
    open fun endsTurn(): Boolean {
        return false
    }
    companion object {
        val commands = arrayOf(
            PlayerCommandHelp(),
            PlayerCommandMove(),
            PlayerCommandLook(),
            PlayerCommandAttack(),
            PlayerCommandWait(),
            PlayerCommandUse(),
            PlayerCommandSearch(),
            PlayerCommandLoot(),
            PlayerCommandInventory(),
            PlayerCommandInspect(),
            PlayerCommandDiscard()
        )
    }
}