package ControlPanel;

public interface IControlPanel {

	public int setTemperature(int celcius);
	
	public boolean turnOnLight();

	public boolean turnOffLight();

	public boolean unlockDoor();

	public boolean lockDoor();
}
