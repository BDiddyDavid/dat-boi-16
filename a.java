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

   boolean buttonB = false;
   boolean buttonB2 = false;

   public void init()
   {
       clamp1 = hardwareMap.servo.get("clamp1");
       clamp2 = hardwareMap.servo.get("clamp2");
   }

   public void loop()
   {
       if (!(buttonB) && (gamepad1.b))
       {
           setClamp(0.5);
           buttonB = true;
       }

       if ((buttonB) && !(gamepad1.b))
       {
           buttonB2 = true;
       }

       if ((buttonB2) && (gamepad1.b))
       {
           setClamp(0.0);
           buttonB2 = false;
       }

       if (!(buttonB2) && !(gamepad1.b))
       {
           buttonB = false;
       }
   }


}
