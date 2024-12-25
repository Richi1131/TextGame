package textGame

open class GameObject : Inspectable {
    private var name: String? = null
    private var description: String? = null
    override fun getName(): String {
        return name!!
    }

    fun setName(name: String) {
        this.name = name.replace(" ", "_")
    }
    fun getDescription(): String {
        return description!!
    }
    fun setDescription(description: String) {
        this.description = description
    }

    override fun toString(): String {
        return name!!
    }

    override fun getAttributes(): Array<String> {
        return arrayOf("Description:" + description)
    }
}
