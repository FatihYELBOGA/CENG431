package Actuators;

import Components.SmartHome;

public class LightBlub extends Actuator{
	
	public LightBlub(SmartHome smartHome) {
		super(smartHome);
	}

	@Override
	public void executeCommand(int celcius) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeCommand(boolean command){ 
		super.getSmartHome().setLight(command);
	}
	
}
