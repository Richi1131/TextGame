package textGame;

public class Head extends BodyPart {
    public Head(Body body) {
        super(body);
    }

    @Override
    public void onDeath() {
        getBody().onDeath();
    }
}
