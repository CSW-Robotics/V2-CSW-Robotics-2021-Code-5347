// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Sub_Pneumatics;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sub_Pneumatics_Right;

public class Cmd_PneumaticsExtend extends CommandBase {
  /** Creates a new Cmd_Pneumatics. */
  private final Sub_Pneumatics m_pneumatics;
  private final Sub_Pneumatics_Right m_pneumatics_right;

  public Cmd_PneumaticsExtend(Sub_Pneumatics subsystem, Sub_Pneumatics_Right subsystem2) {
    m_pneumatics = subsystem;
    m_pneumatics_right = subsystem2;
    addRequirements(m_pneumatics);
    addRequirements(m_pneumatics_right);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  m_pneumatics.extend();
  m_pneumatics_right.extend();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
