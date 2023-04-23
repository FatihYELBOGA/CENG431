package Actuator;


public class LightBulb extends Actuator{
	

	@Override
	public void executeCommand(boolean value) {	
		getSmartHome().setIsLightOpen(value);
	}

	@Override
	public void executeCommand(int value) {
		// TODO Auto-generated method stub
		
	}
	
	

}
