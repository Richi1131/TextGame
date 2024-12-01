package textGame;

public interface Attack {
    public int getDamage();
    public default void attack(Attackable attackable) {
        attackable.getAttacked(this.getDamage());
    }

}
