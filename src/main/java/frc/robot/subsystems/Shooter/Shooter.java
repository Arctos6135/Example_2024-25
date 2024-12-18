package frc.robot.subsystems.Shooter;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private final ShooterIO io;

    private final ShooterInputsAutoLogged inputs = new ShooterInputsAutoLogged(); 

    public Shooter(ShooterIO io){
        this.io = io;
    }

    @Override
    public void periodic(){
        io.updateInputs(inputs);
        Logger.processInputs("shooter", inputs);
    }

    public void setVoltage(double voltage){
        io.setVoltage(voltage);
    }
}
