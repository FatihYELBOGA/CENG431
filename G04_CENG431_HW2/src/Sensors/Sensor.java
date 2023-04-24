package Sensors;

import Components.ISmartHome;

public abstract class Sensor{
	
	private ISmartHome smartHome;
	
	public Sensor(ISmartHome smartHome) {
		this.smartHome = smartHome;
	}
	
	public abstract void read();

	public ISmartHome getSmartHome() {
		return smartHome;
	}

	public void setSmartHome(ISmartHome smartHome) {
		this.smartHome = smartHome;
	}

}
