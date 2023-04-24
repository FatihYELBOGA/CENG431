package Components;

import Sensors.*;
import Actuators.*;
import RandomGenerator.IRandomGenerator;
import RandomGenerator.RandomGenerator;

public class SmartHome implements ISmartHome{
	
	private IRandomGenerator randomGenerator;
	private IControlPanel controlPanel;
	private LightSensor lightSensor;
	private MotionSensor motionSensor;
	private TemperatureSensor temperatureSensor;
	private DoorLock doorLock;
	private LightBlub lightBlub;
	private Thermostat thermostat;
	private int celcius;
	private boolean lock;
	private boolean light;

	public SmartHome() {
		
		this.randomGenerator = new RandomGenerator();
		this.controlPanel = new ControlPanel(this);
		this.lightSensor = new LightSensor(this);
		this.motionSensor = new MotionSensor(this);
		this.temperatureSensor = new TemperatureSensor(this);
		this.doorLock = new DoorLock(this);
		this.lightBlub = new LightBlub(this);
		this.thermostat = new Thermostat(this);
		this.celcius = randomGenerator.generateCelcius();
		this.lock = randomGenerator.generateLock();
		this.light = randomGenerator.generateLight();
		
	}

	@Override
	public void displayStatus() {
		
		this.lightSensor.read();
		this.motionSensor.read();
		this.temperatureSensor.read();
		
	}
	
	@Override
	public IControlPanel getControlPanel() {
		return this.controlPanel;
	}

	@Override
	public void setControlPanel(IControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}
	
	@Override
	public int getCelcius() {
		return this.celcius;
	}

	@Override
	public void changeCelcius(int celcius) {
		this.thermostat.executeCommand(celcius);
	}
	
	@Override
	public void setCelcius(int celcius) {
		this.celcius = celcius;
	}

	@Override
	public boolean isLock() {
		return this.lock;
	}

	@Override
	public void changeLock(boolean lockStatus) {
		this.doorLock.executeCommand(lockStatus);
	}
	
	@Override
	public void setLock(boolean lock) {
		this.lock = lock;
	}

	@Override
	public boolean isLight() {
		return this.light;
	}

	@Override
	public void changeLight(boolean lightStatus) {
		this.lightBlub.executeCommand(lightStatus);
	}
	
	@Override
	public void setLight(boolean light) {
		this.light = light;
	}

}
