// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Sub_NetworkTables;
import frc.robot.subsystems.Sub_Drivetrain;

public class Cmd_PID_Align extends CommandBase {
  /** Creates a new Cmd_PID_Align. */
  
  private final Sub_NetworkTables m_NetworkTables;
  private final Sub_Drivetrain m_DriveTrain;

  public Cmd_PID_Align(Sub_NetworkTables subsystemN, Sub_Drivetrain subsystemD) {
  
  m_NetworkTables = subsystemN;
  addRequirements(m_NetworkTables);

  m_DriveTrain = subsystemD;
  addRequirements(m_DriveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double pitchValue = m_NetworkTables.Pitch();
    double yawValue = m_NetworkTables.Yaw();

    double KpRot=-0.4;
    double KpDist=-0.4;

    //Deadzone is necessary because the robot can only get so accurate and cannot be pefectly head on the target
    double angleTolerance=5;//Deadzone for the angle control loop
    double distanceTolerance=5;//Deadzone for the distance control loop

    double rotationError;
    double distanceError;
    /*
    There is a minimum power that you need to give to the drivetrain in order to overcome friction
    It helps the robot move and rotate at low speeds
    */
    double constantForce=0.05;

    /*
    rotationAjust is rotational signal for the drivetrain
    distanceAjust is forward signal for the drivetrain
    */
    double rotationAjust = 0;
    double distanceAjust = 0;

    SmartDashboard.putNumber("one", 1);
    SmartDashboard.putNumber("four", 4);
    SmartDashboard.putNumber("rotajust", rotationAjust);
    SmartDashboard.putNumber("disajust", distanceAjust);
    

    rotationError=yawValue;
    distanceError=pitchValue;

          
          if(rotationError>angleTolerance){
              rotationAjust=KpRot*rotationError+constantForce;
            }
          else{
              if(rotationError<angleTolerance){
                  rotationAjust=KpRot*rotationError-constantForce;
              }
          }
          

          if(distanceError>distanceTolerance){
              distanceAjust=KpDist*distanceError+constantForce;
            }
          else{
              if(distanceError<distanceTolerance){
                  distanceAjust=KpDist*distanceError-constantForce;
              }
          }

          //Output the power signals to a arcade drivetrain
          m_DriveTrain.drivingNow(distanceAjust,rotationAjust);
  
      
  


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
