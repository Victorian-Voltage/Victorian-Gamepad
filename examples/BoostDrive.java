package examples;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import gamepad.VictorianGamepad;

@TeleOp(name = "Boost Drive")
public class BoostDrive extends DeadzoneDrive {
	private final float BOOST_MULTIPLIER = 1.25f;
	private boolean boost;

	@Override protected void setDrivetrainPower() {
		super.setDrivetrainPower();

		// Add a toggleable drivetrain power boost
		if (vgp1.left_stick_pressed())
			boost = !boost;

		// Or, alternatively,
//		vgp1.update();
//
//		if (vgp1.left_stick_pressed)
//			boost = !boost;

		leftPower *= boost ? BOOST_MULTIPLIER : 1;
		rightPower *= boost ? BOOST_MULTIPLIER : 1;
	}
}
