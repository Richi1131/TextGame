package textGame

class PlayerCommandDiscard: PlayerCommand(arrayOf("discard")) {
    override fun execute(args: Array<String>): Boolean {
        if (args.size != 1) {
            println("Argument has the wrong length.")
            println("discard <target_item>")
            return false
        }
        val item = App.player.inventory.getItemByName(args[0])
        if (item != null) {
            println("Discarded $item.")
            App.player.inventory.removeItem(item)
            return true
        }
        return false
    }
}