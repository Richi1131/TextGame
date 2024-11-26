package textGame;

public class Calculator {
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
}
