package textGame;

public interface Health {
    public int getMaxHealth();
    public void setMaxHealth(int maxHealth);
    public int getHealth();
    public void setHealth(int health);
    public void heal(int amount);
}
