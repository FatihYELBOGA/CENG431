package Sensors;

import Components.ISmartHome;

public class TemperatureSensor extends Sensor{
	
	public TemperatureSensor(ISmartHome smartHome) {
		super(smartHome);
	}

	@Override
	public void read() {
		System.out.println("Celcius: " + super.getSmartHome().getCelcius());
	}



}
