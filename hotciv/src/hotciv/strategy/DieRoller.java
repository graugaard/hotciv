package hotciv.strategy;

public interface DieRoller {
	
	/**
	 * Roll a die, giving a value between 1 and 6
	 * @return The die roll, either 1, 2, 3, 4, 5 or 6
	 */
	public int rollDie();
}
