package textGame;

public class HumanoidBody extends Body {
    protected Arm rightArm;
    protected Arm leftArm;
    protected Leg rightLeg;
    protected Leg leftLeg;

    public HumanoidBody(Character character) {
        super(character);
        this.head = new Head(this);
        this.torso = new Torso(this);

        this.rightArm = new Arm(this);
        this.leftArm = new Arm(this);
        this.rightLeg = new Leg(this);
        this.leftLeg = new Leg(this);
        limbs = new Limb[]{rightArm, leftArm, rightLeg, leftLeg};
    }
}
