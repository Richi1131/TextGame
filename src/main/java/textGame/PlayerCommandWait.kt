package textGame

class PlayerCommandWait: PlayerCommand(arrayOf("wait")) {
    override fun execute(args: Array<String>): Boolean {
        return true
    }

    override fun endsTurn(): Boolean {
        return true
    }
}