package Actuators;

import Components.ISmartHome;

public class DoorLock extends Actuator{
	
	public DoorLock(ISmartHome smartHome) {
		super(smartHome);
	}

	@Override
	public void executeCommand(int celcius) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeCommand(boolean command) {
		super.getSmartHome().setLock(command);
	}

}
