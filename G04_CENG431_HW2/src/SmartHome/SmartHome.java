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
	
	private int celcius;
	
	//true means open
	private boolean isLightOpen;

	//true means locked
	private boolean isDoorLocked;
	
	private Sensor lightSensor;
	
	private Sensor motionSensor;
	
	private Sensor temperatureSensor;
	
	private Actuator doorLockActuator;
	
	private Actuator lightBulbActuator;
	
	private Actuator thermostatActuator;
	
	private IControlPanel controlPanel;
	
	public SmartHome(int celcius,boolean isLightOpen,boolean isDoorLocked) {
		this.celcius=celcius;
		this.isLightOpen=isLightOpen;
		this.isDoorLocked=isDoorLocked;
		initDevices();
	}
	
	private void initDevices() {
		this.doorLockActuator=new DoorLock();
		this.lightBulbActuator=new LightBulb();
		this.thermostatActuator=new Thermostat();
		this.lightSensor=new LightSensor();
		this.motionSensor=new MotionSensor();
		this.temperatureSensor=new TemperatureSensor();
	}
	
	public boolean lockDoor() {
		if(!motionSensor.readStatus()) {
			doorLockActuator.executeCommand(true);
			return true;
		}
		return false;
	}
	
	public boolean unlockDoor() {
		if(motionSensor.readStatus()) {
			doorLockActuator.executeCommand(false);
			return true;
		}
		return false;
	}
	
	public boolean openDoor() {
		if(!lightSensor.readStatus()) {
			lightBulbActuator.executeCommand(true);
		}
		return false;
	}
	
	public boolean closeDoor() {
		if(lightSensor.readStatus()) {
			lightBulbActuator.executeCommand(false);
		}
		return false;
	}
	
	public int changeTemperature(int celcius) {
		thermostatActuator.executeCommand(celcius);
		return celcius;
	}

	public int getCelcius() {
		return celcius;
	}

	public void setCelcius(int celcius) {
		this.celcius = celcius;
	}

	public boolean getIsLightOpen() {
		return isLightOpen;
	}

	public void setIsLightOpen(boolean isLightOpen) {
		this.isLightOpen = isLightOpen;
	}

	public boolean getIsDoorLocked() {
		return isDoorLocked;
	}

	public void setIsDoorLocked(boolean isDoorLocked) {
		this.isDoorLocked = isDoorLocked;
	}
	
	public IControlPanel getControlPanel() {
		return this.controlPanel;
	}

}
