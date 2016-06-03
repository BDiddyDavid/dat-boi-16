package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Brandon on 5/28/2016.
 */

// Test to make sure that intake will work in the correct direction
public class FlyIntakeTest extends OpMode
{
    flywheel flywheel;
    intakeConveyor intakeConveyor;

    public void init()
    {
        flywheel = new flywheel(hardwareMap);
        intakeConveyor = new intakeConveyor(hardwareMap);
    }

    public void loop()
    {
        flywheel.setFly1(gamepad1.left_bumper, gamepad1.left_trigger);
        flywheel.setFly2(gamepad1.right_bumper, gamepad1.right_trigger);
        intakeConveyor.setIntakeConveyor(gamepad1.y, gamepad1.a);
    }
}