package frc.robot.subsystems.flamethrower;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.constants.CANBusConstants;
import frc.robot.constants.FlamethrowerConstants;

public class FlamethrowerIOSparkMax extends FlamethrowerIO{
    public final CANSparkMax motor = new CANSparkMax(CANBusConstants.FLAMETHROWER_CAN_ID, MotorType.kBrushless);

    private final RelativeEncoder encoder;
    
    public FlamethrowerIOSparkMax(){
        motor.setSmartCurrentLimit(FlamethrowerConstants.CURRENT_LIMIT);

        motor.setInverted(true);

        this.encoder = motor.getEncoder();

        encoder.setVelocityConversionFactor(FlamethrowerConstants.VELOCITY_FACTOR);
    }

    @Override
    public void setVoltage(Double voltage){
        motor.setVoltage(voltage);
    }

    // Update the values we're logging
    @Override
    public void updateInputs(FlamethrowerInputs inputs) {

        // Velocity
        inputs.velocity = encoder.getVelocity();

        // Current
        inputs.current = motor.getOutputCurrent();

        // Temperature
        inputs.temperature = motor.getMotorTemperature();

        // Voltage
        inputs.voltage = motor.getBusVoltage() * motor.getAppliedOutput();
    }
}
