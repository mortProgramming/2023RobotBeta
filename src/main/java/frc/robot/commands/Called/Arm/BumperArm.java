package frc.robot.commands.Called.Arm;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class BumperArm extends SequentialCommandGroup {
    
    public BumperArm() {

        addCommands(

            new SequentialCommandGroup(
                new ArmToDegree(55),
                new Wait(0.5),
                new ArmPistonControl(1),
                new Wait(0.5),
                new ArmToDegree(40),
                new ClawControl(0)
            )

        );
    }
}
