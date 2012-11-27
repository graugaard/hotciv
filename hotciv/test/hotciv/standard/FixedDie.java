package hotciv.standard;

import hotciv.strategy.DieRoller;

public class FixedDie implements DieRoller {

	private int roll1;
	private int roll2;
	
	// which of the two to roll
	private boolean nextRollIsRoll1 = true;
	/**
	 * Set up the fixed die. When rolling the die, it will
	 * return the roll predetermined by setup.
	 * @param fixRoll1 Initial setup for uneven rolls
	 * @param fixRoll2 Initial setup for even rolls
	 */
	public FixedDie( int fixRoll1, int fixRoll2 ) {
		this.roll1 = fixRoll1;
		this.roll2 = fixRoll2;
	}
	
	/**
	 * Roll the die, get the fixed result back
	 */
	public int rollDie() {
		int result = 0;
		if ( nextRollIsRoll1 ) {
			result = roll1;
		}
		else {
			result = roll2;
		}
		nextRollIsRoll1 = !nextRollIsRoll1;
		return result;
	}
	
	/**
	 * All uneven number of rolls toll this
	 * @param fixedRoll The value desired to be returned by rollDie()
	 */
	public void setRoll1( int fixedRoll ) {
		this.roll1 = fixedRoll;
	}
	
	/**
	 * All even roll rolls this
	 * @param fixedRoll
	 */
	public void setRoll2( int fixedRoll ) {
		this.roll2 = fixedRoll;
	}
}
