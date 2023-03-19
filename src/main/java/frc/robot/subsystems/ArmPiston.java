package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static frc.robot.util.Constants.*;

public class ArmPiston extends SubsystemBase{
    private static ArmPiston armPiston;

    private static DoubleSolenoid piston;

    private ArmPiston() {
        piston = new DoubleSolenoid(PNEUMATIC_PORT, PneumaticsModuleType.REVPH, OPEN_ARM_PISTON, CLOSE_ARM_PISTON);
    }
    
    public static ArmPiston getInstance() {
        if(armPiston == null){
            armPiston = new ArmPiston();
        }
        return armPiston;
    }
    public void setArmPiston(boolean setArmPiston) {
        if(setArmPiston == false){
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(setArmPiston == true){
            piston.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void setMultiArmPiston(int setArmPiston) {
        if(setArmPiston == 0) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(setArmPiston == 1) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        else if(setArmPiston == 2) {
            piston.toggle();
        }
    }

    public void trueArmPiston() {
        piston.set(DoubleSolenoid.Value.kReverse);
    }

    public void falseArmPiston() {
        piston.set(DoubleSolenoid.Value.kForward);
    }

    public void toggleArmPiston() {
        piston.toggle();
    }

    public DoubleSolenoid.Value getArmPiston() {
        return piston.get();
    }
}
