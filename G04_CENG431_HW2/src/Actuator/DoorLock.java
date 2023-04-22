package Actuator;

import SmartHome.SmartHome;

public class DoorLock extends Actuator{

	private SmartHome smartHome;

	@Override
	public void executeCommand(boolean value) {
		smartHome.setIsDoorLocked(value);
	}

	@Override
	public void executeCommand(int value) {
		// TODO Auto-generated method stub
		
	}
	
}
