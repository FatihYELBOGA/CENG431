package Sensor;

import SmartHome.SmartHome;

public class LightSensor extends Sensor{
	
	private SmartHome smartHome;
		
	@Override
	public boolean readStatus() {
		return smartHome.getIsLightOpen();
	}

	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
