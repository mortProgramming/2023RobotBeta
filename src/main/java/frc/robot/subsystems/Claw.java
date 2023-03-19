package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static frc.robot.util.Constants.*;

public class Claw extends SubsystemBase{
    private static Claw claw;

    private static DoubleSolenoid piston;

    private Claw() {
        piston = new DoubleSolenoid(PNEUMATIC_PORT, PneumaticsModuleType.REVPH, OPEN_CLAW_PISTON, CLOSE_CLAW_PISTON);
    }
    
    public static Claw getInstance() {
        if(claw == null){
            claw = new Claw();
        }
        return claw;
    }

    public void setClaw(boolean setting) {
        if(setting == true){
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        else{
            piston.set(DoubleSolenoid.Value.kForward);
        }
    }

    public void setMultiClaw(int setClaw) {
        if(setClaw == 1) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        else if(setClaw == 0) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(setClaw == 2) {
            piston.toggle();
        }
    }

    public void trueClaw() {
        piston.set(DoubleSolenoid.Value.kForward);
    }

    public void falseClaw() {
        piston.set(DoubleSolenoid.Value.kReverse);
    }

    public void toggleClaw() {
        piston.toggle();
    }

    public DoubleSolenoid.Value getPiston() {
        return piston.get();
    }
}