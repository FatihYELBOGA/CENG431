package Actuators;

import Components.ISmartHome;

public class Thermostat extends Actuator{
	
	public Thermostat(ISmartHome smartHome) {
		super(smartHome);
	}

	@Override
	public void executeCommand(int celcius) {
		super.getSmartHome().setCelcius(celcius);
	}

	@Override
	public void executeCommand(boolean command) {
		// TODO Auto-generated method stub
	}

}
