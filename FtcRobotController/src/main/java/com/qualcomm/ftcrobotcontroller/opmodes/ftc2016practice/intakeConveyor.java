package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Brandon on 5/16/2016.
 */
public class intakeConveyor
{
    DcMotor intake;
    DcMotor conveyor;
    Servo intakeDrop;

    public intakeConveyor (HardwareMap icMap)
    {
        intake = icMap.dcMotor.get("intake");
        conveyor = icMap.dcMotor.get("conveyor");
        intakeDrop = icMap.servo.get("intakeDrop");
    }

    // a = left bumper
    // b = left trigger
    public void setIntakeConveyor (boolean a, double b)
    {
        if (a)
        {
            intake.setPower(1.0);
            conveyor.setPower(1.0);
            intakeDrop.setPosition(0.5);
        }
        else if (b == 1.0)
        {
            intake.setPower(-1.0);
            conveyor.setPower(-1.0);
        }
        else
        {
            intake.setPower(0.0);
            conveyor.setPower(0.0);
        }
    }




}
