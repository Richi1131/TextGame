package textGame

class PlayerCommandUse: PlayerCommand(arrayOf("use")) {
    override fun execute(args: Array<String>): Boolean {
        // TODO: refactor
        if (args.size == 0) {
            println("Argument too short")
            println("use <item> <?target> <?subtarget>")
            return false
        }
        if (args.size == 1) {
            val item = App.player.inventory.getItemByName(args[0])
            if (item is Usable) {
                return item.use()
            } else {
                println(args[0] + " is not usable on another object.")
            }
        }
        if (args.size == 2) {
            val item = App.player.inventory.getItemByName(args[0])
            if (item is UsableOnGameObject) {
                val target = App.player.scene.getGameObjectByName(args[1])
                return item.useOn(target)
            } else {
                println(args[0] + " is not usable on another object.")
            }
        }
        if (args.size == 3) {
            val item = App.player.inventory.getItemByName(args[0])
            if (item is UsableOnGameObject) {
                var target = App.player.scene.getGameObjectByName(args[1])
                if (target is Character) {
                    if (target.body.getBodyPartByName(args[2]) != null) {
                        target = target.body.getBodyPartByName(args[2])
                        return item.useOn(target)
                    } else {
                        println(args[2] + " is not a BodyPart of " + target.body)
                        return false
                    }
                } else {
                    println(args[2] + "has no subtargets.")
                    return false
                }
            }
        }
        return false
    }
}