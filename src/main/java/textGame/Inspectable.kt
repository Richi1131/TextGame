package textGame;

interface Inspectable {
    fun inspect() {
        println("Inspected ${getName()}:")
        for (attribute in getAttributes()) {
            println("   $attribute")
        }
    }
    fun getName(): String
    fun getAttributes(): Array<String>
}
