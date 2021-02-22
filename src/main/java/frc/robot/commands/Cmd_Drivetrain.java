/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Sub_Drivetrain;
import java.util.function.DoubleSupplier;

//creates and names the command
public class Cmd_Drivetrain extends CommandBase {
  
  private final Sub_Drivetrain m_Drivetrain;
  private final DoubleSupplier m_forwardSpeed;
  private final DoubleSupplier m_rotationRate;


  public Cmd_Drivetrain(Sub_Drivetrain subsystem, DoubleSupplier forwardSpeed, DoubleSupplier rotationRate) {
    m_forwardSpeed = forwardSpeed;
    m_rotationRate = rotationRate;
    m_Drivetrain = subsystem;
    addRequirements(m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.drivingNow(m_forwardSpeed.getAsDouble(),m_rotationRate.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
