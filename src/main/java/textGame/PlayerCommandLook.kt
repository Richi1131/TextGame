package textGame

class PlayerCommandLook: PlayerCommand(arrayOf("look")) {
    override fun execute(args: Array<String>): Boolean {
        //todo
        println("You see " + App.player.getScene().getDescription() + ".");
        return true
    }
}