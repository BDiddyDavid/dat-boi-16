package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Brandon on 4/20/2016.
 */

/* Competition date: Saturday, 05/28/16, at Artesia High School
    1st: Gahr Seniors
    2nd: Gahr High School
    3rd: WHS Raymond (us)
    4th: WHS Sophia
    5th: Artesia High School
*/

// Program that initializes all other .java files /////////////////////////////////////////////////

public class TeleOp extends OpMode
{
    drivetrain drivetrain;
    // clampToggle clampToggle; // Not used during competition
    intakeConveyor intakeConveyor;
    flywheel flywheel;

    // Initializing motors
    public void init()
    {
        drivetrain = new drivetrain(hardwareMap);
        // clampToggle = new clampToggle(hardwareMap);
        intakeConveyor = new intakeConveyor(hardwareMap);
        flywheel = new flywheel(hardwareMap);
    }


    public void loop()
    {
        ///// ORGANIZATION ////////////////////////////////////////////////////////////////////////
        //                                                                                       //
        // Drivetrain controlled by left and right joystick, y-direction //////////////////////////
        // Clamp controlled by button B ///////////////////////////////////////////////////////////
        // Intake and conveyor controlled by left bumper and trigger //////////////////////////////
        // Linear slide controlled by right bumper and trigger ////////////////////////////////////
        //                                                                                       //
        ///////////////////////////////////////////////////////////////////////////////////////////
        drivetrain.setDrivePower(gamepad1.left_stick_y, gamepad1.right_stick_y);
        // clampToggle.button(gamepad1.b);
        intakeConveyor.setIntakeConveyor(gamepad1.y, gamepad1.a);
        flywheel.setFly1(gamepad1.left_bumper, gamepad1.left_trigger);
        flywheel.setFly2(gamepad1.right_bumper, gamepad1.right_trigger);
    }
}
