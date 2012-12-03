package hotciv.factories;

import hotciv.strategy.*;

/**
 * This interface will construct the relevant objects
 * for different variation of the game
 * @author jakob
 *
 */
public interface GameFactory {
	/**
	 * How the game calculates age
	 * @return the object to calculate age
	 */
	public AgeStrategy makeAgeStrategy();
	
	/**
	 * Return a winner strategy to determine who wins the game
	 * @return the winner strategy object
	 */
	public WinnerStrategy makeWinnerStrategy();

	/**
	 * Return a strategy that handles unit actions
	 * @return The UnitActionStrategy
	 */
    public UnitActionStrategy makeUnitActionStrategy();
    
    /**
     * Return an attack strategy that handles combat
     * @return The attack strategy
     */
    public AttackStrategy makeAttackStrategy();
    
    /**
     * Return the population strategy
     * @return The population strategy
     */
    public PopulationStrategy makePopulationStrategy();
}
