package textGame

class PlayerCommandMove: PlayerCommand(arrayOf("move")) {
    override fun execute(args: Array<String>): Boolean {
        if (args.size == 0) {
            App.player.move(0)
            println("Player moved.")
            return true
        }
        if (args.size == 1) {
            if (arrayOf(0,1,2,3).contains(args[0].toIntOrNull())) {
                App.player.move(args[0].toInt())
                println("Player moved.")
                return true
            }
            println("${args[0]} is an invalid direction.")
            return false
        }
        println("\"${args.joinToString { " " }}\" is of invalid length.")
        println("\"move <?direction>\" is the valid command.")
        return false
    }
}