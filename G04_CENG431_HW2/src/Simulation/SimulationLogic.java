package Simulation;

import Components.*;
import RandomGenerator.IRandomGenerator;
import RandomGenerator.RandomGenerator;
import java.util.Timer;
import java.util.TimerTask;

public class SimulationLogic implements ISimulationLogic{

	private ISmartHome smartHome;
	private IUser user;
	private IRandomGenerator randomGenerator;
	
	private int counter;
	private int second = 1;

	@Override
	public void initSimulationComponents(ISmartHome smartHome, IUser user) {
		
		this.smartHome = smartHome;
		this.user = user;
		user.setControlPanel(this.smartHome.getControlPanel());
		this.randomGenerator = new RandomGenerator();
		
	}
	
	@Override
	public void readSensorsWithTimerAndNumbers(int miliseconds, int number) {

		counter = number;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				
				System.out.println("Second: " + second);
				second++;
				smartHome.displayStatus();
				System.out.println("--------------------");
				counter--;
				if(counter == 0)
					timer.cancel();
				
				switch(randomGenerator.generateUserOperation()) {
					case 0:
						while(true) {
							int randomCelcius = randomGenerator.generateCelcius();
							if(randomCelcius != smartHome.getCelcius()) {
								user.changeTemperature(randomCelcius);	
								break;
							}
						}
						break;
					case 1:
						if(smartHome.isLight())
							user.changeLightToOff();
						else
							user.changeLightToOn();
						break;
					case 2:
						if(smartHome.isLock())
							user.changeLockToOff();
						else
							user.changeLockToOn();
						break;
				}
				
			}	
		};
		timer.schedule(task, 0, miliseconds);
		
	}

}
