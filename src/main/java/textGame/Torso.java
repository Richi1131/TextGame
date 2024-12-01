package textGame;

public class Torso extends BodyPart {
    public Torso(Body body) {
        super(body, "torso");
    }
    @Override
    public void onDeath() {
        getBody().onDeath();
    }
}
