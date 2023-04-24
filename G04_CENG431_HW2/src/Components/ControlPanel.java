package Components;

public class ControlPanel implements IControlPanel{
	
	private ISmartHome smartHome;
	
	public ControlPanel(ISmartHome smartHome2) {
		this.smartHome = smartHome2;
	}

	@Override
	public void setTemperature(int celcius) {
		this.smartHome.changeCelcius(celcius);
	}

	@Override
	public void turnOnLights() {
		this.smartHome.changeLight(true);
	}

	@Override
	public void turnOffLights() {
		this.smartHome.changeLight(false);
	}

	@Override
	public void lockDoor() {
		this.smartHome.changeLock(true);
	}

	@Override
	public void unlockDoor() {
		this.smartHome.changeLock(false);
	}

}
