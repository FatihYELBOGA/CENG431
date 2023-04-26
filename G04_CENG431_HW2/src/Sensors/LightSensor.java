package Sensors;

import Components.ISmartHome;

public class LightSensor extends Sensor{
	
	public LightSensor(ISmartHome smartHome) {
		super(smartHome);
	}

	@Override
	public void read(){

		String lightStatus = "open";
		if(!super.getSmartHome().isLight())
			lightStatus = "close";
		System.out.println("Light Status: " + lightStatus);	
	}
}
