package Sensor;

import SmartHome.SmartHome;

public class MotionSensor extends Sensor{

	private SmartHome smartHome;
	
	@Override
	public boolean readStatus() {
		return smartHome.getIsDoorLocked();
	}

	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
