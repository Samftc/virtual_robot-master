package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Example Arm Teleop")
public class ExampleTeleop extends OpMode {
    DcMotor BR;
    DcMotor FR;
    DcMotor A;
    DcMotor FL;
    DcMotor BL;
    double Power;
    double RunTime;
    double Turn;

    @Override
    public void init() {
           /* Motors:
   back_right_motor
   front_right_motor
   arm_motor
   front_left_motor
   back_left_motor
 Servos:
   hand_servo*/
        BR = hardwareMap.dcMotor.get("back_right_motor");
        FR = hardwareMap.dcMotor.get("front_right_motor");
        A = hardwareMap.dcMotor.get("arm_motor");
        FL = hardwareMap.dcMotor.get("front_left_motor");
        BL = hardwareMap.dcMotor.get("back_left_motor");

        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {
        Power = gamepad1.left_stick_y;
        Turn = 1.5*gamepad1.left_stick_x;


        BR.setPower(Power -Turn);
        FR.setPower(Power -Turn);
        FL.setPower(Power +Turn);
        BL.setPower(Power +Turn);




    }
}
