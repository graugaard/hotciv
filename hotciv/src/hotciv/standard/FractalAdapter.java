package hotciv.standard;

import hotciv.common.TileImpl;
import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.framework.WorldGeneration;

/**
 * Meant to adapt from fractalGeneration to a WorldGeneration interface
 * @author Jakob
 *
 */
public class FractalAdapter implements WorldGeneration {

	@Override
	public int getWorldHeight() {
		return 16;
	}

	@Override
	public int getWorldWidth() {
		return 16;
	}

	@Override
	public Tile[][] generateTiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City[][] generateCities() {
		City[][] cities = new City[16][16];
		return cities;
	}

	@Override
	public Unit[][] generateUnits() {
		Unit[][] units = new Unit[16][16];
		return units;
	}
	
	public Tile charToTile( char c ) {
		Tile t;
		switch (c) {
		case 'M': t = new TileImpl(GameConstants.MOUNTAINS); break;
		case '.': t = new TileImpl(GameConstants.OCEANS); break;
		case 'f': t = new TileImpl(GameConstants.FOREST); break;
		case 'h': t = new TileImpl(GameConstants.HILLS); break;
		case 'o': t = new TileImpl(GameConstants.PLAINS); break;
		default: t = null;
		}
		return t;
	}

}
