package hotciv.standard.utilities;

import hotciv.framework.*;
import hotciv.standard.*;

public class StringWorldGeneration implements WorldGeneration {
	
	private int height;
	private int width;
	private String[] tileData;
	private String[] cityData;
	private String[] unitData;

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
		this.height = tiles.length;
		this.width = tiles[0].length();
		this.tileData = tiles;
		this.cityData = cities;
		this.unitData = units;
	}
	
	/**
	 * Give a 2d array of strings.
	 * Precondition: worldData[x][y] must fulfill that
	 * 0<= x <= 2, for all x we must have that the
	 * y value must be able to assume the exact same values. i.e
	 * if (x,y) = (0,15) is a valid position, then so is
	 * (2,15) and vice versa.
	 * x = 0 is the tiles data and must fulfill the data specified
	 * in other constructor.
	 * x = 1 is the cities data and must fulfill the data specified
	 * in other constructor.
	 * x = 2 is the units data and must fulfill the data specified
	 * in other constructor.
	 * @param worldData The worlddata used to build the world
	 */
	public StringWorldGeneration( String[][] worldData) {
		this.width = worldData[0][0].length();
		this.height = worldData[0].length;
		this.tileData = worldData[0];
		this.cityData = worldData[1];
		this.unitData = worldData[2];
	}
	
	/**
	 * How high the world is
	 * @return The height
	 */
	public int getWorldHeight() {
		return height;
	}

	/**
	 * The width of the world
	 * @return The width
	 */
	public int getWorldWidth() {
		return width;
	}

	public Tile[][] generateTiles() {
		Tile[][] worldTiles = new Tile[width][height];
		// go through all tile data, set up correct tiles
		for (int y = 0; y < height; y++) {
			String currentRow = tileData[y];
			for (int x = 0; x < width; x++){
				char c = currentRow.charAt(x);
				Tile t = null;
				if ( c == '.') {
					t = new TileImpl(GameConstants.PLAINS);
				}
				if ( c == 'O' ) {
					t = new TileImpl(GameConstants.OCEANS);
				}
				if ( c == 'M' ) {
					t = new TileImpl(GameConstants.MOUNTAINS);
				}
				if ( c == 'f' ) {
					t = new TileImpl(GameConstants.FOREST);
				}
				if ( c == 'h' ) {
					t = new TileImpl(GameConstants.HILLS);
				}
				worldTiles[x][y] = t;
			}
		}
		return worldTiles;
	}

	public City[][] generateCities() {
		City[][] worldCities = new City[width][height];
		for ( int y = 0; y < height; y++ ) {
			String currentRow = cityData[y];
			for (int x = 0; x < width; x++) {
				char c = currentRow.charAt(x);
				City city = null;
				if ( c == 'R' ) {
					city = new CityImpl(Player.RED);
				} if ( c == 'B') {
					city = new CityImpl(Player.BLUE);
				} if ( c == '.') {
					city = null;
				}
				worldCities[x][y] = city;
			}
		}
		return worldCities;
	}

	public Unit[][] generateUnits() {
		Unit[][] worldUnits = new Unit[width][height];
		for ( int y = 0; y < height; y++ ) {
			String currentRow = unitData[y];
			for ( int x = 0; x < width; x++ ) {
				char c = currentRow.charAt(x);
				Unit u = null;
				if ( c == 'A' ) {
					u = new UnitImpl( GameConstants.ARCHER, Player.RED );
				} if ( c == 'a' ) {
					u = new UnitImpl( GameConstants.ARCHER, Player.BLUE);
				} if ( c == 'L' ) {
					u = new UnitImpl( GameConstants.LEGION, Player.RED );
				} if ( c == 'l' ) {
					u = new UnitImpl( GameConstants.LEGION, Player.BLUE );
				} if ( c == 'S' ) {
					u = new UnitImpl( GameConstants.SETTLER, Player.RED );
				} if ( c == 's' ) {
					u = new UnitImpl( GameConstants.SETTLER, Player.BLUE );
				}
				worldUnits[x][y] = u;
			}
		}
		return worldUnits;
	}

}
