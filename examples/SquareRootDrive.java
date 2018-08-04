package examples;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import gamepad.VictorianGamepad;

@TeleOp(name = "Square Root Drive")
public class SquareRootDrive extends TankDrive {
	
	@Override protected void configureGamepads() {
		// Configure vertical thumbstick output to follow a square root curve rather than a line (f[x]=x^1/2 rather than f[x]=x^1)
        VictorianGamepad.Function sqrtCurve = new VictorianGamepad.Function() {
            @Override public float func(double x) { return (float)(Math.signum(x)*Math.sqrt(Math.abs(x))); }
        };

        vgp1.addFloatZone("left_stick_y", 0.0f, 1.0f, sqrtCurve);
        vgp1.addFloatZone("right_stick_y", 0.0f, 1.0f, sqrtCurve);
	}
	
	@Override protected void setDrivetrainPower() {
		leftPower = vgp1.left_stick_y();
		rightPower = vpg1.left_stick_x();
		
		// Or, alternatively,
//		vgp1.update();
//		
//		leftPower = vgp1.left_stick_y;
//		rightPower = vgp1.right_stick_y;
	}
}
