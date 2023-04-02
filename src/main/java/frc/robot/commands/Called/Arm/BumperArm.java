package frc.robot.commands.Called.Arm;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class BumperArm extends SequentialCommandGroup {
    
    public BumperArm() {

        addCommands(

            new SequentialCommandGroup(
                new ArmToDegree(30),
                new ArmPistonControl(1),
                new ArmToDegree(20),
                new ClawControl(0)
            )

        );
    }
}
