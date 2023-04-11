package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Extras;

public class LightsControl extends CommandBase{
    private Extras extras;
    private int settingNum;

    public LightsControl(int settingNum) {
        this.settingNum = settingNum;

        extras = Extras.getInstance();

        addRequirements(extras);
    }

    public void initialize() {
        extras.setLights(settingNum);
    }

    public boolean isFinished() {
        return false;
    }
}
