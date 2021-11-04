// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically it contains the code
 * necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  @Override
  public void robotInit() {
    //Init. for motorcontrollers
    Talon talon0 = new Talon(0);
    Talon talon1 = new Talon(1);
    Talon talon2 = new Talon(2);
    Talon talon3 = new Talon(3);
    //Groups  to allow for multiple motors per side
    SpeedControllerGroup m_LeftMotorGroup = new SpeedControllerGroup(talon0, talon2);
    SpeedControllerGroup m_RightMotorGroup = new SpeedControllerGroup(talon1, talon3);
    //DiffDrive init.
    m_myRobot = new DifferentialDrive(m_LeftMotorGroup, m_RightMotorGroup);
    
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }
  @override
  public void autonomousPeriodic(){
    m_myRobot.tankDrive(1,1);//currently just shoots forward(hopefully)
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
