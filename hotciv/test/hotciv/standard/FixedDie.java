package hotciv.standard;

import hotciv.strategy.DieRoller;

public class FixedDie implements DieRoller {

	private int roll;
	/**
	 * Set up the fixed die. When rolling the die, it will
	 * return the roll predetermined by setup.
	 * @param fixRoll Initial setup
	 */
	public FixedDie( int fixRoll ) {
		this.roll = fixRoll;
	}
	
	/**
	 * Roll the die, get the fixed result back
	 */
	public int rollDie() {
		return roll;
	}
	
	/**
	 * fix the current roll to a new value
	 * @param fixedRoll The value desired to be returned by rollDie()
	 */
	public void fixRoll( int fixedRoll ) {
		this.roll = fixedRoll;
	}

}
