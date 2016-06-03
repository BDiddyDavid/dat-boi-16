package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Brandon on 5/16/2016.
 */
public class intakeConveyor
{
    // DcMotor intake; // intake not used
    DcMotor conveyor;
    // Servo intakeDrop; // intakeDrop not used

    public intakeConveyor (HardwareMap icMap)
    {
   //     intake = icMap.dcMotor.get("intake");
        conveyor = icMap.dcMotor.get("conveyor");
   //     intakeDrop = icMap.servo.get("intakeDrop");
    }

    // a = Button Y
    // b = Button A
    public void setIntakeConveyor (boolean y, boolean a)
    {
        if (y)
        {
          //  intake.setPower(-1.0); // intake in reverse orientation
            conveyor.setPower(0.5); // power reduced from 1.0 to 0.5 so balls do not shoot above crates
          //  intakeDrop.setPosition(0.5);
        }
        else if (a)
        {
          //  intake.setPower(1.0); // intake in reverse orientation
            conveyor.setPower(-1.0);
        }
        else
        {
          //  intake.setPower(0.0);
            conveyor.setPower(0.0);
        }
    }




}
