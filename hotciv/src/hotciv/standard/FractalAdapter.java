package hotciv.standard;

import thirdparty.ThirdPartyFractalGenerator;
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
	int ws = GameConstants.WORLDSIZE;
	ThirdPartyFractalGenerator generator;

	public FractalAdapter() {
		generator = new ThirdPartyFractalGenerator();
	}
	public int getWorldHeight() {
		return ws;
	}

	@Override
	public int getWorldWidth() {
		return ws;
	}

	@Override
	public Tile[][] generateTiles() {
		Tile[][] tiles = new Tile[ws][ws];
		for (int i = 0; i < ws; i++) {
			for (int j = 0; j < ws; j++) {
				char c = generator.getLandscapeAt(i, j);
				tiles[i][j] = charToTile(c);
			}
		}
		return null;
	}

	@Override
	public City[][] generateCities() {
		City[][] cities = new City[ws][ws];
		return cities;
	}

	@Override
	public Unit[][] generateUnits() {
		Unit[][] units = new Unit[ws][ws];
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
