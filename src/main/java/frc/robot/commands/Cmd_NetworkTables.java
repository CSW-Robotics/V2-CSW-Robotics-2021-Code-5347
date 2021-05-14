// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sub_NetworkTables;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Cmd_NetworkTables extends CommandBase {

  private final Sub_NetworkTables m_NetworkTables;
  /** Creates a new Cmd_NetworkTables. */
  public Cmd_NetworkTables(Sub_NetworkTables subsystem) {
    m_NetworkTables = subsystem;
    addRequirements(m_NetworkTables);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  /*  
    m_NetworkTables.Tableinit();
    m_NetworkTables.Yaw();
    m_NetworkTables.Pitch();
    */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  double pitchValue = m_NetworkTables.p_pitch;
  double yawvalue = m_NetworkTables.p_yaw;

  SmartDashboard.putNumber("CMD_Networktables_Pitch", pitchValue);
  SmartDashboard.putNumber("CMD_Networktables_Yaw", yawvalue);


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
