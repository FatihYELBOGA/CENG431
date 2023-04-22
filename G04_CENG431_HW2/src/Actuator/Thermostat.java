package Actuator;

import SmartHome.SmartHome;

public class Thermostat extends Actuator{

	private SmartHome smartHome;


	@Override
	public void executeCommand(boolean value) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeCommand(int value) {
		smartHome.setCelcius(value);
	}

}
