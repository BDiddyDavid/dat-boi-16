package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Brandon on 5/16/2016.
 */
public class linearSlide
{
    DcMotor slide1;
    DcMotor slide2;

    public linearSlide (HardwareMap slideMap)
    {
        slide1 = slideMap.dcMotor.get("slide1");
        slide2 = slideMap.dcMotor.get("slide2");
    }

    // c = right bumper
    // d = right trigger
    public void setLinearSlide(boolean c, double d)
    {
        if (c)
        {
            slide1.setPower(1.0);
            slide2.setPower(1.0);
        }
        else if (d == 1.0)
        {
            slide1.setPower(-1.0);
            slide2.setPower(-1.0);
        }
        else
        {
            slide1.setPower(0.0);
            slide2.setPower(0.0);
        }
    }
}
