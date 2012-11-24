package hotciv.framework;


/**
 * An interface to handle the new world generation
 * @author jakob
 */
public interface WorldGeneration {
	
	/**
	 * Use this to know how high the world is
	 * @return the height of the world
	 */
	public int getWorldHeight();
	
	/**
	 * Use this to know the width of the world
	 * @return width of the world
	 */
	public int getWorldWidth();
	/**
	 * This will give the tiles in the world.
	 * Notice that generateTiles()[x][y] is a valid non null
	 * tile if 0 <= x < getWorldWidth() and
	 * 0 <= y < getWorldHeight(). outside of these values
	 * the array is not accounted for
	 * @return the tiles of the world
	 */
	public Tile[][] generateTiles();
	
	/**
	 * This will give the cities in the world.
	 * Notice that generateCities()[x][y] is a valid non null
	 * tile if 0 <= x < getWorldWidth() and
	 * 0 <= y < getWorldHeight(). outside of these values
	 * the array is not accounted for
	 * @return the cities of the world
	 */
	public City[][] generateCities();
	
	/**
	 * This will give the units in the world.
	 * Notice that generateUnits()[x][y] is a valid non null
	 * tile if 0 <= x < getWorldWidth() and
	 * 0 <= y < getWorldHeight(). outside of these values
	 * the array is not accounted for
	 * @return the units of the world
	 */
	public Unit[][] generateUnits();
}
