package hotciv.standard.utilities;

import hotciv.framework.City;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.framework.WorldGeneration;

public class StringWorldGeneration implements WorldGeneration {
	
	/**
	 * This world generation converts string arrays
	 * into tiles, units and cities.
	 * Precondition: All arrays
	 * have the same size and all strings
	 * have same length
	 * @param tiles The array describing the world tiles. '.' is plains,
	 * 'o' is ocean, 'M' is mountains, 'f' is forest and
	 * 'h' is hills
	 * @param cities The array describing initial cities.
	 * 'R' is a red city, 'B' is a blue city and '.' is not a city
	 * @param units THe array describing the initial units.
	 * 'A' is a red archer, 'L' is a red legion and
	 * 'S' is a red settler. Lower case is blue units,
	 * capital is red units
	 */
	public StringWorldGeneration( String[] tiles, 
			String[] cities, String[] units) {
		
	}
	@Override
	public int getWorldHeight() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getWorldWidth() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Tile[][] generateTiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City[][] generateCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit[][] generateUnits() {
		// TODO Auto-generated method stub
		return null;
	}

}
