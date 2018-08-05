package examples;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import gamepad.VictorianGamepad;

@TeleOp(name = "Deadzone Drive")
public class DeadzoneDrive extends TankDrive {

	@Override protected void configureGamepads() {
		// Add a small deadzone near both thumbsticks' vertical equilibrium
		// positions
		float deadzoneSize = 0.05f;
		VictorianGamepad.Function deadzone = new VictorianGamepad.Function() {
			@Override public float func(double x) { return 0; }
		};

		vgp1.addFloatZone("left_stick_y", 0, deadzoneSize, deadzone);
		vgp1.addFloatZone("right_stick_y", 0, deadzoneSize, deadzone);
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
