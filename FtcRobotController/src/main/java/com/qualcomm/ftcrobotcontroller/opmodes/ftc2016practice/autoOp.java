package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Brandon on 5/16/2016.
 */
public class autoOp extends OpMode
{
    DcMotor driveFL;
    double conversionConstant = 4*Math.PI/1120;

    practice practice = new practice();

    @Override
    public void init()
    {

    }

    @Override
    public void loop()
    {
        if(driveFL.getCurrentPosition()*conversionConstant < 24)
        {
            practice.setLDrivePower(1.0);
            practice.setRDrivePower(1.0);
        }
    }







}
