package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.util.Constants;

public class ArmPiston extends SubsystemBase{
    private static ArmPiston armPiston;

    private static DoubleSolenoid piston;

    private ArmPiston() {
        piston = new DoubleSolenoid(Constants.PNEUMATIC_PORT, PneumaticsModuleType.REVPH, Constants.OPEN_ARM_PISTON, Constants.CLOSE_ARM_PISTON);
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
        else{
            piston.set(DoubleSolenoid.Value.kReverse);
        }
    }
    public DoubleSolenoid.Value getPiston() {
        return piston.get();
    }
}
