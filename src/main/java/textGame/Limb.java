package textGame;

public class Limb extends BodyPart {
    public Limb(Body body, String name) {
        super(body, name);
    }

    @Override
    public void onDeath() {
        System.out.println(getBody().getCharacter() + "'s " + this + " was crippled.");
    }
}
