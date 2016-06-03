package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

  /**
 * Created by Brandon on 5/16/2016.
 */
public class drivetrain
{
    DcMotor driveFL;
    DcMotor driveBL;
    DcMotor driveFR;
    DcMotor driveBR;

    // threshold for joystick values
    double thresh = 0.10;

    public drivetrain (HardwareMap driveMap)
    {
        driveFL = driveMap.dcMotor.get("driveFL");
        driveBL = driveMap.dcMotor.get("driveBL");
        driveFR = driveMap.dcMotor.get("driveFR");
        driveBR = driveMap.dcMotor.get("driveBR");
    }

    // powerA = left joystick, y-direction
    // powerB = right joystick, y-direction
    // Code will only run if threshold (0.10) is surpassed

    public void setDrivePower (double powerA, double powerB)
    {
        if (Math.abs(powerA) > thresh || Math.abs(powerB) > thresh)
        {
            driveFL.setPower(powerA);
            driveBL.setPower(powerA);
            driveFR.setPower(-powerB);  // negative because reversed motor orientation
            driveBR.setPower(-powerB);  // negative because reversed motor orientation
        }
        else
        {
            driveFL.setPower(0.0);
            driveBL.setPower(0.0);
            driveFR.setPower(0.0);
            driveBR.setPower(0.0);
        }
    }
}
