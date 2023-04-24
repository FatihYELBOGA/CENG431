package Components;

public interface IUser {
	
	public IControlPanel getControlPanel();
	public void setControlPanel(IControlPanel controlPanel);
	public void changeTemperature(int celcius);
	public void changeLightToOn();
	public void changeLightToOff();
	public void changeLockToOn();
	public void changeLockToOff();

}
