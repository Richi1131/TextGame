package textGame;

import java.util.Objects;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position position)) {
            return false;
        }
        return (this.x == position.x && this.y == position.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
