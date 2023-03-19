package frc.robot.commands.Called;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class GroundPiece extends SequentialCommandGroup {
    
    public GroundPiece() {

        addCommands(

            new SequentialCommandGroup(
                new TimedDrive(0.5, 0.25, 0.25),
                new ClawControl(1),
                new TimedArm(0.25, 0.3),
                new ArmPistonControl(0),
                new ArmToDegree(20)
            )

        );
    }
}
