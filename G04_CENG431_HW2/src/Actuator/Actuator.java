package Actuator;

import SmartHome.SmartHome;

public abstract class Actuator {
	
	private SmartHome smartHome;
	
	public abstract void executeCommand(boolean value);
	
	public abstract void executeCommand(int value);

}
