/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Sub_Shooter extends SubsystemBase {
  //sets talon port for shooter flywheels
  private final TalonSRX leftFlyWheel = new TalonSRX(Constants.leftFlyWheelPort);
  private final TalonSRX rightFlyWheel = new TalonSRX(Constants.rightFlyWheelPort);

  //Stops motor (sets speed to 0%)
public void stop() {
  leftFlyWheel.set(ControlMode.PercentOutput, 0);
  rightFlyWheel.set(ControlMode.PercentOutput, 0);
}
  //Starts motor (sets speed to 90%)
public void spinUp() {
  leftFlyWheel.set(ControlMode.PercentOutput, 0.9);
  rightFlyWheel.set(ControlMode.PercentOutput, 0.9);
}

  public Sub_Shooter() {

  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
