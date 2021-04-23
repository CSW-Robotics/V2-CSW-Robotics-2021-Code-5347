// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sub_Intake extends SubsystemBase {
  private final TalonSRX intakeMotor = new TalonSRX(Constants.intakeMotorPort);
  /**
   * Creates a new Sub_Intake.
   */
  public Sub_Intake() {

  }
public void spin() {
  intakeMotor.set(ControlMode.PercentOutput, -0.4);
}


public void stop() {
  intakeMotor.set(ControlMode.PercentOutput, 0);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
