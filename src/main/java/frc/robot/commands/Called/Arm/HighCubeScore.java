package frc.robot.commands.Called.Arm;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;
import frc.robot.commands.Control.ClawMotorControl;

public class HighCubeScore extends SequentialCommandGroup {

    public HighCubeScore() {

        addCommands(

            new SequentialCommandGroup(   
                new ClawControl(1),
                new ArmPistonControl(0),
                new TimedArm(1.1, -0.3),  //1.09
                new ParallelCommandGroup(
                    new TimedArm(2, -0.045),
                    new SequentialCommandGroup(
                        new ArmPistonControl(1),
                        new Wait(1),
                        new ArmPistonControl(0),
                        new ClawMotorControl(0.3) //0.25
                    )
                ),
                new ClawMotorControl(0),
                new TimedArm(1, 0.15)
            )
        );
    }
}
