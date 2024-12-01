package textGame;

public class HumanoidBody extends Body {
    protected Arm rightArm;
    protected Arm leftArm;
    protected Leg rightLeg;
    protected Leg leftLeg;

    public HumanoidBody() {
        this.head = new Head();
        this.torso = new Torso();

        this.rightArm = new Arm();
        this.leftArm = new Arm();
        this.rightLeg = new Leg();
        this.leftLeg = new Leg();
        limbs = new Limb[]{rightArm, leftArm, rightLeg, leftLeg};
    }
}
