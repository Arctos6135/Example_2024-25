package frc.robot.subsystems.drivetrain;

import java.io.File;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.SwerveConstants;
import swervelib.SwerveDrive;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveParser;

public class Swerve extends SubsystemBase{
    
    private final SwerveDrive swerveDrive;

    public Swerve(File directory){
        try{
            swerveDrive = new SwerveParser(directory).createSwerveDrive(SwerveConstants.MAX_SPEED);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Command driveCommand(DoubleSupplier translationX, DoubleSupplier translationY, DoubleSupplier angularRotationX){
        return run (() -> {
            swerveDrive.drive(
                SwerveMath.scaleTranslation(new Translation2d(
                    translationX.getAsDouble() * swerveDrive.getMaximumVelocity(),
                    translationY.getAsDouble() * swerveDrive.getMaximumVelocity()
                ), 
                0.8),
                Math.pow(angularRotationX.getAsDouble(), 3) * swerveDrive.getMaximumAngularVelocity(),
                true,
                false
            );
        });
    }

    public void driveFieldOriented(ChassisSpeeds velocity){
        swerveDrive.driveFieldOriented(velocity);
    } 
}
