// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.constants.OtherConstants;
import frc.robot.subsystems.drivetrain.Swerve;

import java.io.File;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final Swerve drivetrain = new Swerve(new File(Filesystem.getDeployDirectory(), "swerve"));

  private final XboxController driverController = new XboxController(OtherConstants.DRIVER_CONTROLLER_PORT);

 
  private final DoubleSupplier driverLeftStickY = () -> driverController.getRawAxis(XboxController.Axis.kLeftY.value);
  private final DoubleSupplier driverLeftStickX = () -> driverController.getRawAxis(XboxController.Axis.kLeftX.value);
  private final DoubleSupplier driverRightStickX = () -> driverController.getRawAxis(XboxController.Axis.kRightX.value);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    drivetrain.setDefaultCommand(drivetrain.driveCommand(driverLeftStickX, driverLeftStickY, driverRightStickX));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    Trigger driverA = new JoystickButton(driverController, XboxController.Button.kA.value);
<<<<<<< HEAD
    Trigger driverB = new JoystickButton(driverController, XboxController.Button.kB.value);

    
    driverA.onTrue(new PrintCommand("You are pressing the A button"));
    driverB.onTrue(new PrintCommand("You are pressing the B button!"));
    dirverB.onFalse(new PrintCommand("You are not pressing the B button!"));
=======
    Trigger driverX = new JoystickButton(driverController, XboxController.Button.kX.value);
    
    driverA.onTrue(new PrintCommand("You are pressing the A button"));
    driverX.onTrue(new PrintCommand("You are pressing the X button"));
>>>>>>> f7e27f36c079fe128aa018e228f65fd5810b5b82
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return Autos.exampleAuto(m_exampleSubsystem);
  // }
}
