package Sensor;


public class LightSensor extends Sensor{
		
	@Override
	public boolean readStatus() {
		return getSmartHome().getIsOpen();
	}

	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
