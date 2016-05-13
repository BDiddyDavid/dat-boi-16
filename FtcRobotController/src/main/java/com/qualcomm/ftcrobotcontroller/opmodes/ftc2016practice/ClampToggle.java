package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Brandon on 5/13/2016.
 */
public class ClampToggle extends OpMode
{
    Servo clamp1;
    Servo clamp2;

    public void setClamp (double position)
    {
        clamp1.setPosition(position);
        clamp2.setPosition(position);
    }

    boolean pressed = false;
    int state = 0;
    int numberOfStates = 2;

    public void init()
    {
        clamp1 = hardwareMap.servo.get("clamp1");
        clamp2 = hardwareMap.servo.get("clamp2");
    }

    public void loop()
    {
        if(gamepad1.b)
        {
            if(!pressed)
            {
                state = (state + 1) % numberOfStates;
            }
            pressed = true;
        }
        else
        {
            pressed = false;
        }

        switch(state)
        {
            case 0:
                setClamp(0.0);
                break;

            case 1:
                setClamp(0.5);
                break;
    }


}
