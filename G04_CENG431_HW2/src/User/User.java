package User;

import ControlPanel.IControlPanel;

public class User {
	
	private IControlPanel controlPanel;
	
	public int setTemperature(int celcius) {
		return controlPanel.setTemperature(celcius);
	}

	
	public boolean turnOnLight() {
		return controlPanel.turnOnLight();
	}

	
	public boolean turnOffLight() {
		return controlPanel.turnOffLight();
	}

	
	public boolean unlockDoor() {
		return controlPanel.unlockDoor();
	}

	
	public boolean lockDoor() {
		return controlPanel.lockDoor();
	}
}
