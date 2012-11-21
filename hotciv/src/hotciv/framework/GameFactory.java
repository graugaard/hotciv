package hotciv.framework;
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

    public UnitActionStrategy makeUnitActionStrategy();
}
