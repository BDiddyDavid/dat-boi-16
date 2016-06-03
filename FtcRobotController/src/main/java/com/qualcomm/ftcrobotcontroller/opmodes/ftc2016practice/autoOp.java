package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Brandon on 5/16/2016.
 */


/* Competition date: Saturday, 05/28/16, at Artesia High School
    1st: Gahr Seniors
    2nd: Gahr High School
    3rd: WHS Raymond (us)
    4th: WHS Sophia
    5th: Artesia High School
*/

// Problem with left turn, never found the correct value

public class autoOp extends OpMode
{

    double conversionConstant = 4.0 * Math.PI / 1120.0;
    // Converting ticks to inches traveled

    drivetrain drivetrain;
    // clampToggle clampToggle; // clampToggle not used in competition
    intakeConveyor intakeConveyor;
    flywheel flywheel;


    int state = 0;
    int offset = 60;
    int offset2 = 84;

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
        telemetry.addData("state: ", state);
        telemetry.addData("encoder: ", drivetrain.driveBL.getCurrentPosition());
        telemetry.addData("calculated: ", Math.abs(drivetrain.driveBL.getCurrentPosition() * conversionConstant));
        // Extra data added to the phone to make sure that the robot is operating in the correct state


        switch (state)
        {
            // ALL values in autoOp have to be opposite for some reason
            case 0:
                drivetrain.setDrivePower(-1.0, -1.0);
                if(Math.abs(drivetrain.driveBL.getCurrentPosition()) * conversionConstant > 48) // 4 feet
                {
                    state = 1;
                }
                break;

            case 1:
                drivetrain.setDrivePower(1.0, -1.0); // turns left
                if ((Math.abs(drivetrain.driveBL.getCurrentPosition()) - offset) * conversionConstant > 96)
                    /* Value "96" caused the robot to make multiple revolutions before stopping and
                         going in random direction, never worked in actual competition */
                {
                    state = 2;
                }
                break;

            case 2:
                drivetrain.setDrivePower(-1.0, -1.0);
                break;
        }
    }
}