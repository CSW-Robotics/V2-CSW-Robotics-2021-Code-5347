// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Sub_Pneumatics;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Cmd_PneumaticsExtend extends CommandBase {
  /** Creates a new Cmd_Pneumatics. */
  private final Sub_Pneumatics m_pneumatics;

  public Cmd_PneumaticsExtend(Sub_Pneumatics subsystem) {
    m_pneumatics = subsystem;
    addRequirements(m_pneumatics);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  m_pneumatics.extend();

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
