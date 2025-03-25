package textGame

import com.google.gson.Gson
import textGame.Utility.Companion.readCsvLine
import textGame.Utility.Companion.readFileLength
import java.io.File
import java.util.*


abstract class GameObjectFactory {
    abstract fun create(gameObjectInformation: Array<String>): GameObject
    abstract fun getCsvPath(): String

    fun createFromCsv(lineNumber: Int): GameObject {
        val gameObjectLine = readCsvLine(getCsvPath(), lineNumber)
        val gameObjectInformation: Array<String> =
            gameObjectLine.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return create(gameObjectInformation)
    }

    fun createRandomFromCsv(): GameObject {
        val rand = Random()
        val lowerBound = 1
        val upperBound = readFileLength(getCsvPath())
        return createFromCsv(rand.nextInt(lowerBound, upperBound))
    }
}