package examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import gamepad.VictorianGamepad;
import java.util.Locale;

public abstract class TankDrive extends OpMode {
    protected VictorianGamepad vgp1, vgp2;
    protected DcMotor dtLeft, dtRight;
    protected float leftPower, rightPower;

    @Override public void init() {
        vgp1 = new VictorianGamepad(gamepad1);
        vgp2 = new VictorianGamepad(gamepad2);
        dtLeft = hardwareMap.dcMotor.get("dtLeft");
        dtRight = hardwareMap.dcMotor.get("dtRight");
   
        dtRight.setDirection(DcMotor.Direction.REVERSE);
        
        telemetry.addData("Robot", "Initialized");
        telemetry.update();
    }

    @Override public void start() {
        telemetry.clearAll();
    }

    @Override public void loop() {
        dtLeft.setPower(leftPower);
        dtRight.setPower(rightPower);
        
        telemetry.addData("Actual left stick", "%.2f", gamepad1.left_stick_y);
        telemetry.addData("Actual right stick", "%.2f", gamepad1.right_stick_y);
        telemetry.addData("Victorian left stick", "%.2f", vgp1.left_stick_y);
        telemetry.addData("Victorian right stick", "%.2f", vgp1.right_stick_y);
        telemetry.addData("Left power", "%.2f", dtLeft.getPower());
        telemetry.addData("Right power", "%.2f", dtRight.getPower());
        telemetry.update();
    }
    
    protected abstract void configureGamepads();
    
    protected abstract void setDrivetrainPower();
}
