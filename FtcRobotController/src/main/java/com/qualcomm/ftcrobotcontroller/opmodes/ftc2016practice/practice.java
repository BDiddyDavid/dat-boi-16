package com.qualcomm.ftcrobotcontroller.opmodes.ftc2016practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Brandon on 4/20/2016.
 */
public class practice extends OpMode
{
    DcMotor driveFL;
    DcMotor driveBL;
    DcMotor driveFR;
    DcMotor driveBR;
    DcMotor intake;
    DcMotor conveyor;
    DcMotor slide1;
    DcMotor slide2;

    Servo intakeDrop;
    Servo clamp1;
    Servo clamp2;

    // Initializing motors ////////////////////////////////////////////////////////////////////////
    public void init()
    {
        // objects in quotation show on phone
        driveFL = hardwareMap.dcMotor.get("driveFL");
        driveBL = hardwareMap.dcMotor.get("driveBL");
        driveFR = hardwareMap.dcMotor.get("driveFR");
        driveBR = hardwareMap.dcMotor.get("driveBR");
        intake = hardwareMap.dcMotor.get("intake");
        conveyor = hardwareMap.dcMotor.get("conveyor");
        slide1 = hardwareMap.dcMotor.get("slide1");
        slide2 = hardwareMap.dcMotor.get("slide2");

        intakeDrop = hardwareMap.servo.get("intakeDrop");
        clamp1 = hardwareMap.servo.get("clamp1");
        clamp2 = hardwareMap.servo.get("clamp2");
    }

    // Function to set intake and conveyor to same power //////////////////////////////////////////
    public void setIntakeConveyor(double power)
    {
        intake.setPower(power);
        conveyor.setPower(power);
    }

    public void setLinearSlide(double power)
    {
        slide1.setPower(power);
        slide2.setPower(power);
    }

    public void setClamp (double position)
    {
        clamp1.setPosition(position);
        clamp2.setPosition(position);
    }

    boolean buttonB = false;
    boolean buttonB2 = false;

    // Threshold value ////////////////////////////////////////////////////////////////////////////
    public double thresh = 0.10;

    public void loop()
    {
        // Drivetrain controlled by L & R Joystick ////////////////////////////////////////////////

        if (Math.abs(gamepad1.left_stick_y) > thresh || Math.abs(gamepad1.right_stick_y) > thresh)
        {
            driveFL.setPower(gamepad1.left_stick_y);
            driveBL.setPower(gamepad1.left_stick_y);
            driveFR.setPower(gamepad1.right_stick_y);
            driveBR.setPower(gamepad1.right_stick_y);
        }
        else
        {
            driveFL.setPower(0.0);
            driveBL.setPower(0.0);
            driveFR.setPower(0.0);
            driveBR.setPower(0.0);
        }

        // Intake & Conveyor controlled by Left Bumper/Trigger ////////////////////////////////////
        if (gamepad1.left_bumper)
        {
            setIntakeConveyor(1.0);
            intakeDrop.setPosition(0.5);
        }
        else if (gamepad1.left_trigger == 1.0)
        {
            setIntakeConveyor(-1.0);
        }
        else
        {
            setIntakeConveyor(0.0);
        }


        // Linear Slide Lift controlled by Right Bumper/Trigger ///////////////////////////////////
        if (gamepad1.right_bumper)
        {
            setLinearSlide(1.0);
        }
        else if (gamepad1.right_trigger == 1.0)
        {
            setLinearSlide(-1.0);
        }
        else
        {
            setLinearSlide(0.0);
        }




        // Linear SlideClamp controlled by Button B //////////////////////////////////////////////

        // buttonB and buttonB2 are boolean values defined as false //////////////////////////////
        // SetClamp is a function that sets position of the two clamp servos /////////////////////
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
