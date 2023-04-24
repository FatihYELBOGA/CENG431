package RandomGenerator;

import java.util.Random;

public class RandomGenerator implements IRandomGenerator{
	
	private Random random = new Random();

	@Override
	public int generateCelcius() {
		return random.nextInt(20) + 20;
	}

	private boolean returnTrueOrFalseRandomly() {
		
		int number_0_or_1 = random.nextInt(2) - 1;
		if(number_0_or_1 == 0)
			return false;
		else
			return true;		
		
	}
	
	@Override
	public boolean generateLock() {
		return returnTrueOrFalseRandomly();
	}

	@Override
	public boolean generateLight() {
		return returnTrueOrFalseRandomly();
	}
	
	@Override
	public int generateUserOperation() {
		return random.nextInt(3);
	}
	
}
