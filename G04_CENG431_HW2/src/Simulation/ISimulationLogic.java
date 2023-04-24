package Simulation;

import Components.ISmartHome;
import Components.IUser;

public interface ISimulationLogic {
	
	public void initSimulationComponents(ISmartHome smartHome, IUser user);
	public void readSensorsWithTimerAndNumbers(int miliseconds, int number);

}
