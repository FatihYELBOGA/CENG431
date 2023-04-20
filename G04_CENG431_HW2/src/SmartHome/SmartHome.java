package SmartHome;

import Actuator.Actuator;
import Actuator.DoorLock;
import Actuator.LightBulb;
import Actuator.Thermostat;
import ControlPanel.IControlPanel;
import Sensor.LightSensor;
import Sensor.MotionSensor;
import Sensor.Sensor;
import Sensor.TemperatureSensor;

public class SmartHome {
	
	private LightSensor lightSensor;
	
	private MotionSensor motionSensor;
	
	private TemperatureSensor temperatureSensor;
	
	private DoorLock doorLockActuator;
	
	private LightBulb lightBulbActuator;
	
	private Thermostat thermostatActuator;
	
	private IControlPanel controlPanel;
	
	public int setTemperature(int celcius) {
		return this.controlPanel.setTemperature(celcius);
	}
	
	public boolean getIsOpen() {
		return false;
	}
	
	public boolean turnOnOffLight() {
		boolean isOpen=lightSensor.readStatus();
		
		lightBulbActuator.executeCommand(!isOpen);
		
		return !isOpen;
	}
	
	public boolean lockUnlockDoor() {
		return this.controlPanel.lockUnlockDoor();
	}

}
