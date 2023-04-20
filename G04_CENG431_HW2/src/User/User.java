package User;

import ControlPanel.IControlPanel;

public class User {
	
	private IControlPanel controlPanel;
	
	public boolean turnOnOffLight() {
		return controlPanel.turnOnOffLight();
	}

	public boolean lockUnlockDoor() {
		return controlPanel.lockUnlockDoor();
	}
}
