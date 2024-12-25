package textGame;

import java.util.Random;

public abstract class GameObjectCsvFactory {
    public abstract GameObject create(String[] gameObjectInformation);
    public abstract String getCsvPath();
    public GameObject createFromCsv(int lineNumber) {
        String gameObjectLine = Utility.readCsvLine(getCsvPath(), lineNumber);
        String[] gameObjectInformation = gameObjectLine.split(",");
        return create(gameObjectInformation);
    }
    public GameObject createRandomFromCsv() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength(getCsvPath());
        return createFromCsv(rand.nextInt(lowerBound, upperBound));
    }
}
