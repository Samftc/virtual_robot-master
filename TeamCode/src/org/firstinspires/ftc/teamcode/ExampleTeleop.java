package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Example Arm Teleop")
public class ExampleTeleop extends OpMode {
    DcMotor BR;
    DcMotor FR;
    DcMotor A;
    DcMotor FL;
    DcMotor BL;
    Servo HS; //Hand Servo
    double Power;
    double RunTime;
    double Turn;
    double Servo;
    double Arm;

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
        HS = hardwareMap.servo.get("hand_servo");

        //setting motor directions
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {
        Power = gamepad1.left_stick_y; //variable for controller power on motors
        Turn = 1.5*gamepad1.left_stick_x; //variable is used for turning


        HS.setPosition(Servo);  // sets the position of the servo
        A.setPower(Arm);    //controls the arm motor

        Arm = -gamepad1.right_stick_y;

        BR.setPower(Power +Turn);  //controls movement... forward, backward, left, right
        FR.setPower(Power +Turn);
        FL.setPower(Power -Turn);
        BL.setPower(Power -Turn);

        if(gamepad1.x){
            Servo = 0; //sets the servo to open

        }
        else if(gamepad1.b){
            Servo =  180; //sets the servo to closed
        }




    }
}
