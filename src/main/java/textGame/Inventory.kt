package textGame

class Inventory (size: Int) {
    val items: Array<Item?> = arrayOfNulls(size)
    fun getItemByName(name: String): Item? {
        return items.filterNotNull().find{it.getName() == name}
    }

    fun addItem(item: Item?): Boolean {
        for (i in items.indices) {
            if (items[i] == null) {
                items[i] = item
                return true
            }
        }
        return false
    }

    fun removeItem(item: Item): Boolean {
        for (i in items.indices) {
            if (items[i] === item) {
                items[i] = null
                return true
            }
        }
        return false
    }

    val isFull: Boolean
        get() {
            var isFull = true
            for (item in items) {
                if (item == null) {
                    isFull = false
                    break
                }
            }
            return isFull
        }

    override fun toString(): String {
        var output = "( "
        for (i in items.indices) {
            output = output + items[i] + " "
        }
        output = "$output)"
        return output
    }
}