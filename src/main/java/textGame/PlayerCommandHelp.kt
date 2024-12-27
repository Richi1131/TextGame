package textGame

class PlayerCommandHelp: PlayerCommand(arrayOf("help")) {
    override fun execute(args: Array<String>): Boolean {
        //todo
        println("todo")
        for (command in commands) {
            print("- ")
            for (word in command.keywords) {
                print("$word ")
            }
            println()
        }
        return true
    }
}