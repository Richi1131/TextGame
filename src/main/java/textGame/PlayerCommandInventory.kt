package textGame

class PlayerCommandInventory: PlayerCommand(arrayOf("inventory")) {
    override fun execute(args: Array<String>): Boolean {
        println(App.player.inventory)
        return true
    }
}