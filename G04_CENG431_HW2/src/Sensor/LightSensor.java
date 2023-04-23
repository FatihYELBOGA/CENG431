package Sensor;


public class LightSensor extends Sensor{
			
	@Override
	public boolean readStatus() {
		return getSmartHome().getIsLightOpen();
	}

	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
