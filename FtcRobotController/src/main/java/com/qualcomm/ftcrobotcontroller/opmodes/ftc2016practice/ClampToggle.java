package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Brandon on 5/13/2016.
 */
public class clampToggle // clampToggle not used during competition
{
    Servo clamp1;
    Servo clamp2;

    public clampToggle(HardwareMap clampMap)
    {
        clamp1 = clampMap.servo.get("clamp1");
        clamp2 = clampMap.servo.get("clamp2");
    }

    // Function allows position of clamp1 and clamp2 to be set simultaneously
    public void setClamp (double position)
    {
        clamp1.setPosition(position);
        clamp2.setPosition(position);
    }

    // Toggle program developed by Moses "MossyApples" Won

    boolean pressed = false;
    int state = 0;
    int numberOfStates = 2;

    // y = button B
    public void button(boolean y)
    {
        if(y)
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


}
