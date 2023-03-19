package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.util.Constants.*;

public class PneumaticsHub extends SubsystemBase{
    private static PneumaticsHub pneumaticHub;
    private static Compressor compressor;

    private PneumaticsHub() {
        compressor = new Compressor(PNEUMATIC_PORT, PneumaticsModuleType.REVPH);
    }

    public static PneumaticsHub getInstance() {
        if(pneumaticHub == null){
            pneumaticHub = new PneumaticsHub();
        }
        return pneumaticHub;
    }

    public void setCompressorDigital(){
        compressor.enableDigital();
    }

    public void setCompressorAnalog(){
        compressor.enableAnalog(COMPRESSER_MIN_PRESSURE, COMPRESSER_MAX_PRESSURE);
    }

    public double getPressure() {
        return compressor.getPressure();
    }
}
