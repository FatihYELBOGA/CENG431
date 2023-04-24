package Components;

public class User implements IUser{
	
	private IControlPanel controlPanel;
	
	@Override
	public IControlPanel getControlPanel() {
		return this.controlPanel;
	}

	@Override
	public void setControlPanel(IControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	@Override
	public void changeTemperature(int celcius) {
		this.controlPanel.setTemperature(celcius);
	}

	@Override
	public void changeLightToOn() {
		this.controlPanel.turnOnLights();
	}

	@Override
	public void changeLightToOff() {
		this.controlPanel.turnOffLights();
	}

	@Override
	public void changeLockToOn() {
		this.controlPanel.lockDoor();
	}

	@Override
	public void changeLockToOff() {
		this.controlPanel.unlockDoor();
	}
	
}
