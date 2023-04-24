package Simulation;

import Components.*;

public class Main {

	public static void main(String[] args) {
	
		ISmartHome smartHome = new SmartHome();
		IUser user = new User();
		SimulationLogic simulation = new SimulationLogic();
		simulation.initSimulationComponents(smartHome, user);
		simulation.readSensorsWithTimerAndNumbers(1000, 20);
		
	}

}
