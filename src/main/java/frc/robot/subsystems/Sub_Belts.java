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


public class Sub_Belts extends SubsystemBase {
  //sets talon port for Belts
  private final TalonSRX spinBelts = new TalonSRX(Constants.spinBeltsPort);

  //Stops motor (sets speed to 0%)
public void stop() {
  spinBelts.set(ControlMode.PercentOutput, 0);
}
  //Starts motor (sets speed to 50%)
public void spinUp() {
  spinBelts.set(ControlMode.PercentOutput, .5);
}

  public Sub_Belts() {

  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
