// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sub_Pneumatics;

public class Cmd_PneumaticsRetract extends CommandBase {

  private final Sub_Pneumatics m_Pneumatics;
  /** Creates a new Cmd_PneumaticsRetract. */

  public Cmd_PneumaticsRetract(Sub_Pneumatics subsystem) {
    m_Pneumatics = subsystem;
    addRequirements(m_Pneumatics);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Pneumatics.retract();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
