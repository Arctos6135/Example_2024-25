package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.flamethrower.Flamethrower;

public class ShootShooter extends Command {
    private Shooter shooter;
    private double time;
    private double timer;

    public ShootShooter(Shooter s, int t){
        this.shooter = s;
        this.time = t;

        addRequirements(s);
    }

    public void intialize(){
        shooter.setVoltage(100);
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
        shooter.setVoltage(0);
    }

}
