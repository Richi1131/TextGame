package textGame

class SceneFactory: GameObjectCsvFactory() {
    override fun create(locationInformation: Array<out String>?): GameObject {
        val scene = Scene()

        scene.setName(locationInformation!![0])
        scene.setDescription(locationInformation!![1])
        //todo: danger and value sysems
        //scene.setDanger(locationInformation!![2].toInt())
        //scene.setValue(locationInformation[3].toInt())

        scene.addNpc(FactoryManager.generateRandomNpc())
        scene.addRandomLoot()

        return scene
    }

    override fun getCsvPath(): String {
        return "src/main/resources/locations.csv"
    }
}