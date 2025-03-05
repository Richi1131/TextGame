package textGame

import java.io.File
import java.io.FileNotFoundException
import java.util.*

class Utility {
    companion object {
        fun calculateNewPosition(position: Position, direction: Int): Position {
            var targetPosition = Position(position)
            if (direction == 0) {
                targetPosition.y++
            } else if (direction == 1) {
                targetPosition.x++
            } else if (direction == 2) {
                targetPosition.y--
            } else if (direction == 3) {
                targetPosition.x--
            }
            return targetPosition;
        }

        fun readCsvLine(path: String?, lineNumber: Int): String {
            try {
                val sc = Scanner(File(path))
                sc.useDelimiter(",")
                var i = 0
                while (sc.hasNext()) {
                    val line = sc.nextLine()
                    if (i == lineNumber) {
                        return line
                    }
                    i++
                }
                sc.close()
            } catch (e: FileNotFoundException) {
                return ""
            }
            return ""
        }

        fun readFileLength(path: String?): Int {
            try {
                val sc = Scanner(File(path))
                sc.useDelimiter(",")
                var length = 0
                while (sc.hasNext()) {
                    sc.nextLine()
                    length++
                }
                return length
            } catch (e: FileNotFoundException) {
            }
            return 0
        }

        fun characterArrayToString(characters: Array<Character>): String {
            val buffer = StringBuffer()
            buffer.append("( ")
            for (character in characters) {
                buffer.append(character.getName())
                buffer.append(" ")
            }
            buffer.append(")")
            return buffer.toString()
        }
    }
}