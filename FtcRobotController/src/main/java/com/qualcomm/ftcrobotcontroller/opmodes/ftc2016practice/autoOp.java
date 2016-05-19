package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Brandon on 5/16/2016.
 */

// INCOMPLETE /////////////////////////////////////////////////////////////////////////////////////
// INCOMPLETE /////////////////////////////////////////////////////////////////////////////////////
// INCOMPLETE /////////////////////////////////////////////////////////////////////////////////////

public class autoOp extends OpMode
{
    DcMotor driveFL;
    double conversionConstant = 4*Math.PI/1120;

    drivetrain drivetrain;
    clampToggle clampToggle;
    intakeConveyor intakeConveyor;
    linearSlide linearSlide;
    int state;

    @Override
    // Initializing motors
    public void init()
    {
        drivetrain = new drivetrain(hardwareMap);
        clampToggle = new clampToggle(hardwareMap);
        intakeConveyor = new intakeConveyor(hardwareMap);
        linearSlide = new linearSlide(hardwareMap);
    }
    @Override
    public void loop()
    {
        if(driveFL.getCurrentPosition()*conversionConstant < 24)
        {

        }
    }







}
