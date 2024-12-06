package textGame;

public interface UsableOnGameObject {
    /// returns true for if used on compatible object else returns false
    public abstract boolean useOn(GameObject gameObject);
}
