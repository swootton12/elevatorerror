// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drivesubsystem extends SubsystemBase {
  WPI_TalonSRX lmotora = new WPI_TalonSRX(1);
  WPI_TalonSRX lmotorb = new WPI_TalonSRX(2);
  WPI_TalonSRX rmotora = new WPI_TalonSRX(3);
  WPI_TalonSRX rmotorb = new WPI_TalonSRX(4);
  MotorControllerGroup leftMotors = new MotorControllerGroup(lmotora, lmotorb);
  MotorControllerGroup rightMotors = new MotorControllerGroup(rmotora, rmotorb);
  DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);
  XboxController drivestick = new XboxController(0);
  public void setmotors(){
  rightMotors.setInverted(true);
  leftMotors.setInverted(false);
m_drive.setMaxOutput(0.67);
  }
 public drivesubsystem() {

  }
  public CommandBase exampleMethodCommand() {
    return runOnce(
        () -> {
        });
  }

  public boolean exampleCondition() {
    return false;
  }

  @Override
  public void periodic() {
    m_drive.tankDrive(-drivestick.getLeftY(), drivestick.getRightX());
  }

  @Override
  public void simulationPeriodic() {
  }
}
