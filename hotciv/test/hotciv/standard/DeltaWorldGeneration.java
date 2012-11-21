package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.framework.WorldGeneration;

public class DeltaWorldGeneration implements WorldGeneration {

	@Override
	public int getWorldHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorldWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tile[][] generateTiles() {
		// TODO Auto-generated method stub
		int worldSize = GameConstants.WORLDSIZE;
		Tile[][] tiles = 
				new Tile[worldSize][worldSize];
        for(int i = 0; i < worldSize; i++)
            for(int j = 0; j < worldSize; j++)
                tiles[i][j] = new TileImpl(GameConstants.PLAINS);
        // special tiles, since most is plains
        tiles[1][0] = new TileImpl(GameConstants.OCEANS);
        tiles[0][1] = new TileImpl(GameConstants.HILLS);
        tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
		return tiles;
	}

	@Override
	public City[][] generateCities() {
		int worldSize = GameConstants.WORLDSIZE;
		City[][] cities = new City[worldSize][worldSize];
		cities[8][12] = new CityImpl(Player.RED);
		cities[4][5] = new CityImpl(Player.BLUE);
		return cities;
	}

	@Override
	public Unit[][] generateUnits() {
		// TODO Auto-generated method stub
		return null;
	}

}
