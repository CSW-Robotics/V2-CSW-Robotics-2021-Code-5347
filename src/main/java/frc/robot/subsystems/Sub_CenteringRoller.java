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

public class Sub_CenteringRoller extends SubsystemBase {
  
  //sets talon port for centering rollers
  private final TalonSRX roller = new TalonSRX(Constants.rollerPort);
  public Sub_CenteringRoller() {

  }
  //sets roller speed to 100% 
  //pushes available dodgeballs into the flywheels
  public void startRoller(){
    roller.set(ControlMode.PercentOutput, 1);
  }
  //set roller speed to 0% 
  public void stopRoller(){
    roller.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
