package textGame;

public class Arm extends Limb {
    private Hand hand;
    public Arm(Body body, String name) {
        super(body, name);
        this.hand = new Hand(this);
    }
}
