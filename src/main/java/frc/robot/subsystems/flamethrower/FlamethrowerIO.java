package frc.robot.subsystems.flamethrower;
import org.littletonrobotics.junction.AutoLog;


public class FlamethrowerIO {

    // Logging
    @AutoLog
    public static class FlamethrowerInputs{
        
        public double velocity;
        public double current;
        public double temperature;
        public double voltage;
    }


    // Update the sensor data either using acutal sensors or simulated values.
    public void updateInputs(FlamethrowerInputs inputs) {}

    public void setVoltage(Double voltage){}

}
