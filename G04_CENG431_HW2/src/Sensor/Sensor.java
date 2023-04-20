package Sensor;

import SmartHome.SmartHome;

public abstract class Sensor {

	private SmartHome smartHome;

	public abstract boolean readStatus();
	
	public abstract int readValue();
	
	public SmartHome getSmartHome() {
		return smartHome;
	}
}
