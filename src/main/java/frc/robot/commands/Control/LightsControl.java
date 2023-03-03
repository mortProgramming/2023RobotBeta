package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lights;

public class LightsControl extends CommandBase{
    private Lights lights;
    private boolean setting;
    private int lightNum;

    public LightsControl(int lightNum, boolean setting) {
        this.setting = setting;
        this.lightNum = lightNum;

        lights = Lights.getInstance();

        addRequirements(lights);
    }

    public void initialize() {
        lights.setLights(lightNum, setting);
    }

    public boolean isFinished() {
        return false;
    }
}
