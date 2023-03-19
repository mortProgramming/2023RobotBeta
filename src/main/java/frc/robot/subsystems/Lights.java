package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.util.Constants.*;

public class Lights extends SubsystemBase {
    private static Lights lights;

    private static DigitalOutput light1;
    private static DigitalOutput light2;
    private static DigitalOutput light3;

    public Lights() {
        light1 = new DigitalOutput(LIGHT_2);
        light2 = new DigitalOutput(LIGHT_1);
        light3 = new DigitalOutput(LIGHT_3);
    }

    public static Lights getInstance() {
        if(lights == null){
        lights = new Lights();
        }
        return lights;
    }

    // public void setLights(int settingNum, boolean input) {
        public void setLights(int settingNum) {
        // if(lightNum == 1) {
        //     light1.set(input);
        // }
        // else if(lightNum == 2) {
        //     light2.set(input);
        // }
        // else {
        //     light3.set(input);
        // }
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
}
