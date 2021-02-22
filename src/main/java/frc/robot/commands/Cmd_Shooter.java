// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Sub_Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Cmd_Shooter extends CommandBase {
  /** Creates a new Cmd_Shooter. */

private final Sub_Shooter m_Shooter;

  public Cmd_Shooter(Sub_Shooter Subsystem) {
    m_Shooter = Subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Shooter.spinUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Shooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
