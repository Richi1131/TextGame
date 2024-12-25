package textGame;

import java.util.Random;

public abstract class GameObjectCsvFactory {
    public abstract GameObject create(String[] itemInformation);
    public abstract String getCsvPath();
    public GameObject createFromCsv(int lineNumber) {
        String itemLine = Utility.readCsvLine(getCsvPath(), lineNumber);
        String[] itemInformation = itemLine.split(",");
        return create(itemInformation);
    }
    public GameObject createRandomFromCsv() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength(getCsvPath());
        return createFromCsv(rand.nextInt(lowerBound, upperBound));
    }
}
