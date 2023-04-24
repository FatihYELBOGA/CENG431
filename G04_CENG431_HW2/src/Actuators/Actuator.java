package Actuators;

import Components.ISmartHome;

public abstract class Actuator {
	
	private ISmartHome smartHome;
	
	public Actuator(ISmartHome smartHome) {
		this.smartHome = smartHome;
	}
	
	public abstract void executeCommand(int celcius);
	public abstract void executeCommand(boolean command);

	public ISmartHome getSmartHome() {
		return smartHome;
	}

	public void setSmartHome(ISmartHome smartHome) {
		this.smartHome = smartHome;
	}
	
}
