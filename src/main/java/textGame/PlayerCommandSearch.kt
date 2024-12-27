package textGame

class PlayerCommandSearch: PlayerCommand(arrayOf("search")) {
    override fun execute(args: Array<String>): Boolean {
        if (args.size == 1) {
            if (args[0] == "scene") {
                App.player.scene.search()
                return true
            } else {
                val target = App.player.scene.getGameObjectByName(args[0])
                if (target is Searchable) {
                    target.search()
                    return true
                } else {
                    println(target.toString() + " is not searchable.")
                    return false
                }
            }
        }
        return false
    }
}