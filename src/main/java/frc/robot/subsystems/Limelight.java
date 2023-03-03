package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    private static Limelight limelight;
    private static NetworkTable table;

    private Limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    public static Limelight getInstance() {
        if(limelight == null){
            limelight = new Limelight();
        }
        return limelight;
    }

    public static double limeLightSee(){
        return table.getEntry("tv").getDouble(0);
    }
    public static double limeLightX(){
        return table.getEntry("tx").getDouble(0);
    }
    public static double limeLightY(){
        return table.getEntry("ty").getDouble(0);
    }
    public static double limeLightArea(){
        return table.getEntry("ta").getDouble(0);
    }
}
