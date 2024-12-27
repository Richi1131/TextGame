package textGame

class PlayerCommandAttack: PlayerCommand(arrayOf("attack")) {
    override fun execute(args: Array<String>): Boolean {
        if (args.size == 1) {
            val target = args[0]
            if (target == "self") {
                println("You try to hit yourself.")
                App.player.attack(App.player)
                return true
            } else if (App.player.scene.getNpc(target) != null) {
                println("You try to hit " + App.player.scene.getNpc(target) + ".")
                App.player.attack(App.player.scene.getNpc(target))
                return true
            } else {
                println("Unknown target.")
            }
        }
        return false
    }
    override fun endsTurn(): Boolean {
        return true;
    }
}