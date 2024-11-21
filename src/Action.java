public class Action {
    public String description;

    public Action(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
