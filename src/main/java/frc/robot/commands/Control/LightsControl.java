package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lights;

public class LightsControl extends CommandBase{
    private Lights lights;
    private boolean setting;
    private int settingNum;

    // public LightsControl(int settingNum, boolean setting) {
    public LightsControl(int settingNum) {
        // this.setting = setting;
        this.settingNum = settingNum;

        lights = Lights.getInstance();

        addRequirements(lights);
    }

    public void initialize() {
        // lights.setLights(lightNum, setting);
        lights.setLights(settingNum);
    }

    public boolean isFinished() {
        return false;
    }
}
