package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PowerDistribution;

import static frc.robot.util.Constants.*;

public class Extras extends SubsystemBase {
    private static Extras extras;

    private static DigitalOutput light1;
    private static DigitalOutput light2;
    private static DigitalOutput light3;

    private static PowerDistribution powerDistribution;

    public Extras() {
        light1 = new DigitalOutput(LIGHT_2);
        light2 = new DigitalOutput(LIGHT_1);
        light3 = new DigitalOutput(LIGHT_3);

        powerDistribution = new PowerDistribution(PDH, PowerDistribution.ModuleType.kRev);
    }

    public static Extras getInstance() {
        if(extras == null){
        extras = new Extras();
        }
        return extras;
    }

        public void setLights(int settingNum) {
        if(settingNum == 1) {
            light1.set(false);
            light2.set(false);
            light3.set(false);
        }
        else if(settingNum == 2) {
            light1.set(false);
            light2.set(true);
            light3.set(true);
        }
        else if(settingNum == 3) {
            light1.set(true);
            light2.set(false);
            light3.set(true);
        }
        else if(settingNum == 4) {
            light1.set(true);
            light2.set(true);
            light3.set(false);
        }
        else if(settingNum == 5) {
            light1.set(true);
            light2.set(false);
            light3.set(false);
        }
        else if(settingNum == 6) {
            light1.set(false);
            light2.set(true);
            light3.set(false);
        }
        else if(settingNum == 7) {
            light1.set(false);
            light2.set(false);
            light3.set(true);
        }
        else {
            light1.set(true);
            light2.set(true);
            light3.set(true);
        }
    }

    public void headextras(boolean power) {
        powerDistribution.setSwitchableChannel(power);
    }

    // public double getVoltage() {
    //     return powerDistribution.getVoltage();
    // }
}
