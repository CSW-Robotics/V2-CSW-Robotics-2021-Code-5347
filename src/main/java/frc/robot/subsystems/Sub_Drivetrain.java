/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedController; 
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Sub_Drivetrain extends SubsystemBase {
  //sets tal on port for left wheel motors and right wheel motors
  private final WPI_TalonSRX leftWheels1 = new WPI_TalonSRX(Constants.leftWheels1Port);
  private final WPI_TalonSRX leftWheels2 = new WPI_TalonSRX(Constants.leftWheels2Port);
  private final WPI_TalonSRX rightWheels1 = new WPI_TalonSRX(Constants.rightWheels1Port);
  private final WPI_TalonSRX rightWheels2 = new WPI_TalonSRX(Constants.rightWheels2Port);
  //sets talon port for gyro (none)
  //private final AHRS gyro = new AHRS(1);
  //left and right Speed Controller Groups
  //SPI.Port.kMXP

  private final SpeedControllerGroup leftSpeConGru = new SpeedControllerGroup(leftWheels1,leftWheels2);
  private final SpeedControllerGroup rightSpeConGru = new SpeedControllerGroup(rightWheels1,rightWheels2);

  private final DifferentialDrive TankDrive = new DifferentialDrive(leftSpeConGru,rightSpeConGru);

  public void drivingNow(double forwardSpeed, double rotationRate){
    TankDrive.arcadeDrive(forwardSpeed, rotationRate);
  }

  public Sub_Drivetrain() {

  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
