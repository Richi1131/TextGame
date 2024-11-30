import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import textGame.Utility;

public class UtilityTest {
    @Test
    public void readCsvTest() {
        System.out.println(Utility.readCsvLine("src/main/resources/locations.csv", 1));
    }
    @Test
    public void getFileLengthTest() {
        System.out.println(Utility.readFileLength("src/main/resources/locations.csv"));
    }
}
