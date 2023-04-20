package Actuator;

public class LightBulb extends Actuator{
	
	private boolean isOpen;

	
	public boolean getIsOpen() {
		return isOpen;
	}
	
	@Override
	public void executeCommand(boolean value) {
		isOpen=value;	
	}

	@Override
	public void executeCommand(int value) {
		// TODO Auto-generated method stub
		
	}
	
	

}
