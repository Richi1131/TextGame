package textGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class ItemFactory {
    public abstract Item create(String[] itemInformation);
    public abstract String getCsvPath();
    public Item createFromCsv(int lineNumber) {
        String itemLine = Utility.readCsvLine(getCsvPath(), lineNumber);
        String[] itemInformation = itemLine.split(";");
        return create(itemInformation);
    }
    public Item createRandomFromCsv() {
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = Utility.readFileLength(getCsvPath());
        return createFromCsv(rand.nextInt(lowerBound, upperBound));
    }
}
