package hotciv.framework;

import java.util.List;

/**
 * This interface extends the game interface with
 * mutator methods
 * @author jakob
 *
 */
public interface ExtendedGame extends Game {

	/**
	 * Remove unit from the game at a
	 * certain position
	 * @param p The position where the unit is located
	 */
	public void removeUnitAt(Position p);
	
	/**
	 * Add a city at the desired location
	 * Precondition: The position must be valid
	 * @param p The position where the city should
	 * be added
	 * @param c The city one wishes to add
	 */
	public void addCity(City c, Position p);
	
	/**
	 * Get a list of battles occurred in the order they
	 * have occurred
	 * @return The list of battles, in the order they have occurred
	 */
	public List<Battle> getBattleHistory();
	
	/**
	 * Gives a list of positions, starting due north
	 * of the center in the distance specified
	 * then going clockwise around
	 * @param center The center of the circle
	 * @param distance How far out the positions should be gathered
	 * @return The list of positions
	 */
	public List<Position> getPositions(Position center, int distance);
	
	/**
	 * A list of cities in the world. Ordered lexographically by position, e.g.
	 * (x,y) > (x',y') if x > x' and if x = x', y > y'.
	 * @return The list
	 */
	public List<City> getCities();

    public int getCurrentRound();
}
