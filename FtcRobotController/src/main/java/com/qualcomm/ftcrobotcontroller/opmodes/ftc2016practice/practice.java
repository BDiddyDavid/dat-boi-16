package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Brandon on 4/20/2016.
 */

// Program that initializes all other .java files /////////////////////////////////////////////////

public class practice extends OpMode
{
    drivetrain drivetrain;
    clampToggle clampToggle;
    intakeConveyor intakeConveyor;
    linearSlide linearSlide;

    // Initializing motors
    public void init()
    {
        drivetrain = new drivetrain(hardwareMap);
        clampToggle = new clampToggle(hardwareMap);
        intakeConveyor = new intakeConveyor(hardwareMap);
        linearSlide = new linearSlide(hardwareMap);
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
        clampToggle.button(gamepad1.b);
        intakeConveyor.setIntakeConveyor(gamepad1.left_bumper, gamepad1.left_trigger);
        linearSlide.setLinearSlide(gamepad1.right_bumper, gamepad1.right_trigger);
    }
}
