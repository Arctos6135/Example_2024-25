package frc.robot.subsystems.flamethrower;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flamethrower extends SubsystemBase{
    private final FlamethrowerIO io;

    // Logging
    private final FlamethrowerInputsAutoLogged inputs = new FlamethrowerInputsAutoLogged();
        
    public Flamethrower(FlamethrowerIO io){
        this.io = io;
    }

    // Runs 50 times a second, on subsystems we only use this method for logging.  
    @Override
    public void periodic(){
        // This tells our subsystem (either real or simulated) to update our class with all the sensor data.
        io.updateInputs(inputs);

        // Log all the sensor data.
        Logger.processInputs("Flamethrower", inputs);
    }


    public void setVoltage(double voltage){
        io.setVoltage(voltage);
    }
}
