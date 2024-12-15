package textGame;

public class GameObject {
    private String name;
    private String description;
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setName(String name) {
        this.name = name.replace(" ", "_");
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return this.name;
    }
}
