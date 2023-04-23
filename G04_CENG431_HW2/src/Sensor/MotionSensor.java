package Sensor;


public class MotionSensor extends Sensor{
	
	@Override
	public boolean readStatus() {
		return getSmartHome().getIsDoorLocked();
	}

	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
