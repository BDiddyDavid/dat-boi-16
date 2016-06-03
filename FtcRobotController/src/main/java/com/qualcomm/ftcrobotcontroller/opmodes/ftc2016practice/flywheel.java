package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Brandon on 5/16/2016.
 */
public class flywheel
{
    DcMotor fly1; //left
    DcMotor fly2; //right

    public flywheel (HardwareMap flyMap)
    {
        fly1 = flyMap.dcMotor.get("fly1");
        fly2 = flyMap.dcMotor.get("fly2");
    }

    // c = left bumper
    // d = left trigger
    public void setFly1(boolean c, double d)
    {
        if (c)
        {
            fly1.setPower(1.0);
        }
        else if (d == 1.0)
        {
            fly1.setPower(-1.0);
        }
        else
        {
            fly1.setPower(0.0);
        }
    }

    // e = right bumper
    // f = right trigger
    public void setFly2(boolean e, double f)
    {
        if (e)
        {
            fly2.setPower(-1.0); //motor fly2 has reversed orientation, values are *-1
        }
        else if (f == 1.0)
        {
            fly2.setPower(1.0); //motor fly2 has reversed orientation, values are *-1
        }
        else
        {
            fly2.setPower(0.0);
        }
    }
}
