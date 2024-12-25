package textGame

class HumanoidBodyFactory: BodyFactory() {
    override fun create(): Body {
        val body = Body()
        body.head = Head(body)
        body.torso = Torso(body)

        body.limbs = Array<Limb?>(4) {null}
        body.limbs[0] = Arm(body, "right_arm")
        body.limbs[1] = Arm(body, "left_arm")
        body.limbs[2] = Leg(body, "right_leg")
        body.limbs[3] = Leg(body, "left_leg")
        body.limbs = body.limbs.filterNotNull().toTypedArray()

        return body
    }
}