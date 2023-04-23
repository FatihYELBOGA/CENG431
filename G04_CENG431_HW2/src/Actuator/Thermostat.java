package Actuator;

public class Thermostat extends Actuator{


	@Override
	public void executeCommand(boolean value) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeCommand(int value) {
		getSmartHome().setCelcius(value);
	}

}
