package textGame;

public class Torso extends BodyPart {
    public Torso(Body body) {
        super(body);
    }
    @Override
    public void onDeath() {
        getBody().onDeath();
    }
}
