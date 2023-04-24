package RandomGenerator;

import java.util.Random;

public class RandomGenerator {
	
	private Random random;
	
	public RandomGenerator() {
		this.random=new Random();
	}
	
	public int generateRandomInterval(int lower,int upper) {
		int randomInt = random.nextInt(upper-lower+1);
		return randomInt+lower;
	}
	
	public boolean generateRandomBoolean() {
		return random.nextBoolean();
	}

}
