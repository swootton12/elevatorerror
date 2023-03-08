package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
public class elevator extends SubsystemBase {
    private final CANSparkMax sped1 = new CANSparkMax(6, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax sped2 = new CANSparkMax(7, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless);
    public  MotorControllerGroup sped = new MotorControllerGroup(sped1, sped2);
    Joystick subsystems = new Joystick(0);
    JoystickButton eup = new JoystickButton(subsystems, 6);
    JoystickButton edown = new JoystickButton(subsystems, 4);

  /** Creates a new ExampleSubsystem. */
  //public Trigger eTrigger(){
   // Trigger edown = new JoystickButton(subsystems, 4);
    //return edown;


  public elevator() {}
 public void motoron(double set) {
    sped.set(0.67);
}
public void motoroff(double set){
    sped.set(0);
}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    return null;
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
   //edown.whileTrue(motoron(0));
   //edown.whileFalse(motoroff(1));
    if (subsystems.getRawButton(6)){
      sped.set(.5);
    }
    else if (subsystems.getRawButton(4)){
      sped.set(-.5);
    }
    else {
    sped.set(0);
  }
  }

/*public void motoron(double set) {
    sped.set(1);
}
public void motoroff(double set){
    sped.set(0);
}*/

@Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
