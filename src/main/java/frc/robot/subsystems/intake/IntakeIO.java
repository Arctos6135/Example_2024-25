
package frc.robot.subsystems.intake;
import org.littletonrobotics.junction.AutoLog;

public class IntakeIO {
    @AutoLog
    public static class IntakeInputs{
        public double velocity;
        public double current;
        public double temperature;
        public double voltage;
    }

    public void updateInputs(IntakeInputs inputs) {}

    public void setVoltage(double voltage) {}
}
