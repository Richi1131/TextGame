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

        this.rightArm = new Arm(this, "right arm");
        this.leftArm = new Arm(this, "left arm");
        this.rightLeg = new Leg(this, "right leg");
        this.leftLeg = new Leg(this, "left leg");
        limbs = new Limb[]{rightArm, leftArm, rightLeg, leftLeg};
    }
}
