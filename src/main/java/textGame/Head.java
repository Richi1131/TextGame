package textGame;

public class Head extends BodyPart {
    public Head(Body body) {
        super(body, "head");
    }

    @Override
    public void onDeath() {
        getBody().onDeath();
    }
}
