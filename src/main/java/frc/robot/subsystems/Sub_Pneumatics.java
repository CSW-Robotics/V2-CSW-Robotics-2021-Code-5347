// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

/** Add your docs here. */
public class Sub_Pneumatics extends SubsystemBase {
  // sets talon port for Pneumatics
  private final DoubleSolenoid beaverTail = new DoubleSolenoid(Constants.compressorPort,Constants.solLeft, Constants.solRight);

//extend the intake
public void extend(){
  beaverTail.set(kForward);
}
//retract the intake
public void retract(){
  beaverTail.set(kReverse);
}
//make the intake manually movable
public void goLimp(){
  beaverTail.set(kOff);
}

  @Override
  public void periodic() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

