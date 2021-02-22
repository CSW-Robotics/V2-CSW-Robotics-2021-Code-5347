/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.Sub_Elevator;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Cmd_Elevator extends CommandBase {

  private final Sub_Elevator m_Elevator;
  /**
   * Creates a new Cmd_Elevator.
   */
  public Cmd_Elevator(Sub_Elevator subsystem) {
    m_Elevator = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Elevator.pullElevUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Elevator.letElevDown();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
