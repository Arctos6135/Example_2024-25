package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.flamethrower.Flamethrower;

public class RaiseArm extends Command {
    private Flamethrower flamethrower;
    private double time;
    private double timer;

    public RaiseArm(Flamethrower f, int t){
        this.flamethrower = f;
        this.time = t;

        addRequirements(f);
    }

    public void intialize(){
        flamethrower.setVoltage(100);
    }

    public void execute() {
        timer += 0.02;
    }

    public boolean isFinished(){
        if(timer >= time)
        {
            return true;
        }

        return false;
    }

    public void end(boolean interrupted) {
        flamethrower.setVoltage(0);
    }

}
