package hotciv.strategy;


import java.util.Random;

public class RandomDie implements DieRoller {
	private Random randomGenerator = new Random();
	public int rollDie() {
		// we roll a number between 0 and 5. Add
		// 1 to get one between 1 and 6;
		return randomGenerator.nextInt( 5 ) + 1;
	}

}
