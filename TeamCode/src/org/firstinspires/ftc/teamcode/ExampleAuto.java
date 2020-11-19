package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Example Arm Auto")
//@Disabled
public class ExampleAuto extends LinearOpMode {
    /* Motors:
   back_right_motor
   front_right_motor
   arm_motor
   front_left_motor
   back_left_motor
 Servos:
   hand_servo*/
    DcMotor BR;
    DcMotor FR;
    DcMotor A;
    DcMotor FL;
    DcMotor BL;

    double RunPower;
    double RunTime;
    @Override
    public void runOpMode() throws InterruptedException {
        BR = hardwareMap.dcMotor.get("back_right_motor");
        FR = hardwareMap.dcMotor.get("front_right_motor");
        A = hardwareMap.dcMotor.get("arm_motor");
        FL = hardwareMap.dcMotor.get("front_left_motor");
        BL = hardwareMap.dcMotor.get("back_left_motor");

        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);

        RunPower = 1;
        waitForStart();

        resetStartTime();
        RunTime = getRuntime();
                while(RunTime < 2){
                    BR.setPower(RunPower);
                    FR.setPower(RunPower);
                    FL.setPower(RunPower);
                    BL.setPower(RunPower);
                    RunTime = getRuntime();
                }

        resetStartTime();
        RunTime = getRuntime();
        while(RunTime < 1){
            BR.setPower(1);
            FR.setPower(1);
            FL.setPower(-1);
            BL.setPower(-0);
            RunTime = getRuntime();
        }
        BR.setPower(0);
        FR.setPower(0);
        FL.setPower(0);
        BL.setPower(0);

    }
}
