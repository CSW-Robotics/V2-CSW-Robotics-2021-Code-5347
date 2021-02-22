/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Sub_Elevator extends SubsystemBase {
  //sets talon port for elevator
  private final TalonSRX elevator = new TalonSRX(Constants.elevatorPort); 

  //Stops motor (sets speed to 0%)
public void stop() {
  elevator.set(ControlMode.PercentOutput, 0);
}
  //Starts motor (sets speed to 100%)
  //pulls the elevator up at full speed
public void pullElevUp() {
  elevator.set(ControlMode.PercentOutput, 1);
}
  //starts motor (sets speed to -100%)
  //lets the elevator down at full speed
public void letElevDown(){
  elevator.set(ControlMode.PercentOutput, -1);
}

  public Sub_Elevator() {
  }

  @Override
  public void periodic(){
  }
}

