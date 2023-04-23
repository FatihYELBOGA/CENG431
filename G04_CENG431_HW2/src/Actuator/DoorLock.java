package Actuator;


public class DoorLock extends Actuator{


	@Override
	public void executeCommand(boolean value) {
		getSmartHome().setIsDoorLocked(value);
	}

	@Override
	public void executeCommand(int value) {
		// TODO Auto-generated method stub
		
	}
	
}
