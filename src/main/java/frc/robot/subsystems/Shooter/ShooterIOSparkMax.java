package frc.robot.subsystems.Shooter;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.constants.CANBusConstants;
import frc.robot.constants.ShooterConstants;

public class ShooterIOSparkMax extends ShooterIO{
    public final CANSparkMax left = new CANSparkMax(CANBusConstants.SHOOTER_LEFT_CAN_ID, MotorType.kBrushless);
    public final CANSparkMax right = new CANSparkMax(CANBusConstants.SHOOTER_RIGHT_CAN_ID, MotorType.kBrushless);

    private final RelativeEncoder leftEncoder;
    private final RelativeEncoder rightEncoder;

    public ShooterIOSparkMax(){
        left.setSmartCurrentLimit(ShooterConstants.CURRENT_LIMIT);
        right.setSmartCurrentLimit(ShooterConstants.CURRENT_LIMIT);
        left.follow(right, true);

        this.leftEncoder = left.getEncoder();
        this.rightEncoder = right.getEncoder();

        leftEncoder.setVelocityConversionFactor(ShooterConstants.VELOCITY_FACTOR);
        rightEncoder.setVelocityConversionFactor(ShooterConstants.VELOCITY_FACTOR);
    }

    @Override
    public void setVoltage(double voltage){
        right.setVoltage(voltage);
    }

    @Override
    public void updateInputs(ShooterInputs inputs){

        inputs.velocity = leftEncoder.getVelocity();
        inputs.position = leftEncoder.getPosition();
        inputs.temperature = left.getMotorTemperature();
        inputs.current = left.getOutputCurrent();
        inputs.voltage = left.getBusVoltage() * left.getAppliedOutput();
    }
}