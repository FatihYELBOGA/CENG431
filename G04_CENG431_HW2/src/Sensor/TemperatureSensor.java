package Sensor;


public class TemperatureSensor extends Sensor {
	

	@Override
	public boolean readStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int readValue() {
		return getSmartHome().getCelcius();
	}

}
