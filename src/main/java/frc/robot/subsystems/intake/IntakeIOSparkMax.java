package frc.robot.subsystems.intake;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.constants.CANBusConstants;
import frc.robot.constants.FlamethrowerConstants;
import frc.robot.constants.IntakeConstants;

public class IntakeIOSparkMax extends IntakeIO {
    public final CANSparkMax motor = new CANSparkMax(CANBusConstants.INTAKE_CAN_ID, MotorType.kBrushless); 

    public final RelativeEncoder encoder;

    public IntakeIOSparkMax() {
        motor.setSmartCurrentLimit(FlamethrowerConstants.CURRENT_LIMIT);

        motor.setInverted(true);

        this.encoder = motor.getEncoder();

        encoder.setVelocityConversionFactor(FlamethrowerConstants.VELOCITY_FACTOR);
    }


    @Override
    public void setVoltage(double voltage) {
        motor.setVoltage(voltage);
    }

    @Override
    public void updateInputs(IntakeInputs inputs) {

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
