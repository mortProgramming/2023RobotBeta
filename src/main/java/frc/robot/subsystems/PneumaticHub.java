package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;

public class PneumaticHub extends SubsystemBase{
    private static PneumaticHub pneumaticHub;
    private static Compressor compressor;

    private PneumaticHub() {
        compressor = new Compressor(Constants.PNEUMATIC_PORT, PneumaticsModuleType.REVPH);
    }

    public static PneumaticHub getInstance() {
        if(pneumaticHub == null){
            pneumaticHub = new PneumaticHub();
        }
        return pneumaticHub;
    }

    public void setCompressorDigital(){
        compressor.enableDigital();
    }

    public void setCompressorAnalog(){
        compressor.enableAnalog(Constants.COMPRESSER_MIN_PRESSURE, Constants.COMPRESSER_MAX_PRESSURE);
    }
}
