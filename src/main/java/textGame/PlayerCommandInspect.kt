package textGame

class PlayerCommandInspect: PlayerCommand(arrayOf("inspect")) {
    override fun execute(args: Array<String>): Boolean {
        if (args.size == 2) {
            var target: GameObject? = null
            if (args[1] == "inventory") {
                target = App.player.inventory.getItemByName(args[0])
            } else if (args[1] == "scene") {
                target = App.player.scene.getGameObjectByName(args[0])
            }
            if (target is Inspectable) {
                target.inspect()
                return true
            } else {
                println(target.toString() + " is not inspectable.")
                return false
            }
        } else {
            println("Argument has the wrong length.")
            println("inspect <target_item> <target_container>")
            return false
        }
    }
}