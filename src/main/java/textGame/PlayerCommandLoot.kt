package textGame

class PlayerCommandLoot: PlayerCommand(arrayOf("loot")) {
    override fun execute(args: Array<String>): Boolean {
        if (args.size == 2) {
            if (args[1] == "scene") {
                return App.player.loot(App.player.scene, args[0])
            } else {
                val target = App.player.scene.getGameObjectByName(args[1])
                if (target is Lootable) {
                    return App.player.loot(target, args[0])
                } else {
                    println(target.toString() + " is not lootable.")
                    return false
                }
            }
        } else {
            println("Argument has the wrong length.")
            println("loot <target_item> <target_container>")
            return false
        }
    }

}