/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController.Axis;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Sub_Shooter;
import frc.robot.subsystems.Sub_Elevator;
import frc.robot.subsystems.Sub_Drivetrain;
import frc.robot.subsystems.Sub_CenteringRoller;
import frc.robot.subsystems.Sub_Belts;
import frc.robot.commands.Cmd_Shooter;
import frc.robot.commands.Cmd_ElevatorUp;
import frc.robot.commands.Cmd_Intake;
//import frc.robot.commands.Cmd_Drivetrain;
import frc.robot.commands.Cmd_Belts;
import frc.robot.commands.Cmd_CenteringRoller;
//import frc.robot.commands.Cmd_Drivetrain;
import frc.robot.subsystems.Sub_Intake;
import frc.robot.subsystems.Sub_Pneumatics;
import frc.robot.commands.Cmd_ElevatorDown;
import frc.robot.commands.Cmd_PneumaticsExtend;
import frc.robot.commands.Cmd_PneumaticsRetract;
import frc.robot.subsystems.Sub_NetworkTables;
import frc.robot.commands.Cmd_PID_Align;
import frc.robot.subsystems.Sub_Pneumatics_Right;
import frc.robot.commands.Cmd_NetworkTables;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_ExampleSubsystem = new ExampleSubsystem();
  private final Joystick m_drivestick = new Joystick(Constants.joyPort);
  private final XboxController m_controller = new XboxController(Constants.ctrlPort);
  private final Sub_Shooter m_shooter = new Sub_Shooter();
  private final Sub_Elevator m_elevator = new Sub_Elevator();
  private final Sub_Drivetrain m_drivetrain = new Sub_Drivetrain();
  private final Sub_CenteringRoller m_centerroller = new Sub_CenteringRoller();
  private final Sub_Belts m_belts = new Sub_Belts();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_ExampleSubsystem);
  private final Sub_Intake m_intake = new Sub_Intake();
  private final Sub_Pneumatics m_pneumatics = new Sub_Pneumatics();
  private final Sub_NetworkTables m_networkTables = new Sub_NetworkTables();
  private final Sub_Pneumatics_Right m_pneumatics_right = new Sub_Pneumatics_Right();
  


  




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new RunCommand(()-> m_drivetrain.drivingNow(m_drivestick.getRawAxis(1), m_drivestick.getRawAxis(2)), m_drivetrain));
    //m_networkTables.setDefaultCommand(new RunCommand(()-> m_networkTables.Tableinit()));
    // Configure the button bindings
    
   //m_networkTables.setDefaultCommand(new RunCommand(() -> m_networkTables.Yaw()));
   //m_networkTables.setDefaultCommand(new  RunCommand(() -> m_networkTables.Pitch()));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_controller, 6).whileHeld(new Cmd_Shooter(m_shooter));
    //new JoystickButton(m_controller, 5).whileHeld(new Cmd_ElevatorUp(m_elevator));
    new JoystickButton(m_controller, 8).whileHeld(new Cmd_Belts(m_belts));
    new JoystickButton(m_controller, 3).whileHeld(new Cmd_CenteringRoller(m_centerroller));
    new JoystickButton(m_controller, 2).whileHeld(new Cmd_Intake(m_intake));
    //new JoystickButton(m_controller, 7).whileHeld(new Cmd_ElevatorDown(m_elevator));
    new JoystickButton(m_controller, 4).whileHeld(new Cmd_PID_Align(m_networkTables, m_drivetrain));

    new JoystickButton(m_controller, 10).whileHeld(new Cmd_PneumaticsExtend(m_pneumatics, m_pneumatics_right));
    new JoystickButton(m_controller, 9).whileHeld(new Cmd_PneumaticsRetract(m_pneumatics, m_pneumatics_right));
    new JoystickButton(m_controller, 7).whileHeld(new Cmd_NetworkTables(m_networkTables));
    //new JoystickButton(m_controller, 19).whileActiveContinuous(new Cmd_NetworkTables(m_networkTables), interruptible)
    
    }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public ExampleCommand getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
    
  }
}
