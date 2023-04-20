package ControlPanel;

import SmartHome.SmartHome;

public class ControlPanel implements IControlPanel{
	
	private SmartHome smartHome;

	@Override
	public int setTemperature(int celcius) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean turnOnOffLight() {
		return smartHome.turnOnOffLight();
	}

	@Override
	public boolean lockUnlockDoor() {
		// TODO Auto-generated method stub
		return false;
	}

}
