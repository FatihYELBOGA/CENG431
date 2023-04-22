package Sensor;

import SmartHome.SmartHome;

public class TemperatureSensor extends Sensor {
	
	private SmartHome smartHome;

	@Override
	public boolean readStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int readValue() {
		return smartHome.getCelcius();
	}

}
