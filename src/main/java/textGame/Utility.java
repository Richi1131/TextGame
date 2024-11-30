package textGame;

import java.io.*;
import java.util.Scanner;

public class Utility {
    // TODO: rename
    /// takes position and direction, outputs postion after moving in direction
    public static Position calculateNewPosition(Position position, int direction) {
        Position targetPosition = new Position(position);
        if (direction == 0) {
            targetPosition.y++;
        }
        else if (direction == 1) {
            targetPosition.x++;
        }
        else if (direction == 2) {
            targetPosition.y--;
        }
        else if (direction == 3) {
            targetPosition.x--;
        }
        return targetPosition;
    }
    public static String readCsvLine(String path, int lineNumber) {
        try {
            Scanner sc = new Scanner(new File(path));
            sc.useDelimiter(",");
            int i = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (i == lineNumber) {
                    return line;
                }
                i++;
            }
            sc.close();

        } catch (java.io.FileNotFoundException e) {
            return "";
        }
        return "";
    }
    public static int readFileLength(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            sc.useDelimiter(",");
            int length = 0;
            while (sc.hasNext()) {
                sc.nextLine();
                length++;
            }
            return length;

        } catch (java.io.FileNotFoundException e) {
        }
        return 0;
    }
}
