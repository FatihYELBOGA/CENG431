package Components;

public interface ISmartHome {
	
	public IControlPanel getControlPanel();
	public void displayStatus();
	public void setControlPanel(IControlPanel controlPanel);
	public int getCelcius();
	public void changeCelcius(int celcius);
	public void setCelcius(int celcius);
	public boolean isLight();
	public void changeLight(boolean lightStatus);
	public void setLight(boolean lightStatus);
	public boolean isLock();
	public void changeLock(boolean lockStatus);
	public void setLock(boolean lockStatus);

}
