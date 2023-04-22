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
	public boolean turnOnLight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turnOffLight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockDoor() {
		return smartHome.unlockDoor();
	}

	@Override
	public boolean lockDoor() {
		return smartHome.lockDoor();		
	}

}
