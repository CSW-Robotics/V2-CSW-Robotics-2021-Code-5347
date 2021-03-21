// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Sub_NetworkTables extends SubsystemBase {
  /** Creates a new Sub_NetworkTables. */

  public NetworkTable table;
  public NetworkTableEntry yaw;
  public NetworkTableInstance Visiontable;
  public NetworkTableEntry pitch;

  public Sub_NetworkTables() {

  }

  public void Tableinit(){
    NetworkTableInstance Visiontable = NetworkTableInstance.getDefault();
    NetworkTable table = Visiontable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
    NetworkTableEntry yaw = table.getEntry("yaw");
    NetworkTableEntry pitch = table.getEntry("pitch");
  }
  public double Yaw(){
    double d_yaw;
    NetworkTableInstance Visiontable = NetworkTableInstance.getDefault();
    NetworkTable table = Visiontable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
    NetworkTableEntry yaw = table.getEntry("yaw");
    d_yaw = yaw.getDouble(0.0);
    return d_yaw;
  }

  public double Pitch(){
    double d_pitch;
    NetworkTableInstance Visiontable = NetworkTableInstance.getDefault();
    NetworkTable table = Visiontable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
    NetworkTableEntry pitch = table.getEntry("pitch");
    d_pitch = pitch.getDouble(0.0);
    return d_pitch;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
