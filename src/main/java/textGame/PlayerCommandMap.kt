package textGame

class PlayerCommandMap : PlayerCommand(arrayOf("map")) {
    override fun execute(args: Array<String>): Boolean {
        val currentPosition = App.player.scene.position
        println("┌──────────────────┐")
        for (i in (currentPosition!!.y-2..currentPosition!!.y+2).reversed()) {
            var line = "│"
            for (j in currentPosition!!.x-4..currentPosition!!.x+4) {
                val iterationPosition = Scene.getByPosition(j, i)
                if (iterationPosition == null) {
                    line += "  "
                } else {
                    line = "$line${iterationPosition.getMapDepiction()} "
                }
            }
            println(line+"│")
        }
        println("└──────────────────┘")
        return false
    }
}