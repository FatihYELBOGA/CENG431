package Sensors;

import Components.ISmartHome;

public class MotionSensor extends Sensor{
	
	public MotionSensor(ISmartHome smartHome) {
		
		super(smartHome);
	}

	@Override
	public void read() {
		
		String lockStatus = "lock";
		if(!super.getSmartHome().isLock())
			lockStatus = "unlock";
		System.out.println("Door Status: " + lockStatus);
	}

}
