package hotciv.standard;

import java.util.HashMap;

import hotciv.common.CityImpl;
import hotciv.common.TileImpl;
import hotciv.common.UnitImpl;
import hotciv.framework.*;
import hotciv.standard.*;

public class DeltaWorldGeneration implements WorldGeneration {
	int worldSize = GameConstants.WORLDSIZE;
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
		Tile[][] tiles = 
				new Tile[worldSize][worldSize];
		HashMap<Position, Tile> world = worldMap();
		for (int i = 0; i < worldSize; i++) {
			for (int j = 0; j < worldSize; j++) {
				tiles[i][j] = world.get(new Position(i,j));
			}
		}
		return tiles;
	}

	@Override
	public City[][] generateCities() {
		
		City[][] cities = new CityImpl[worldSize][worldSize];
		cities[8][12] = new CityImpl(Player.RED);
		cities[4][5] = new CityImpl(Player.BLUE);
		return cities;
	}

	@Override
	public Unit[][] generateUnits() {
		
		Unit[][] units = new UnitImpl[worldSize][worldSize];
		units[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED);
		units[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE);
		units[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED);
		return units;
	}
	
	/**
	 * Blatantly stolen from SoftArk homepage
	 * Thanks to Henrik for easing the workload
	 * @return
	 */
	private HashMap<Position, Tile> worldMap() {
		HashMap<Position, Tile> world = new HashMap<Position, Tile>();
		String[] layout = new String[] {
		          "...ooMooooo.....",
		          "..ohhoooofffoo..",
		          ".oooooMooo...oo.",
		          ".ooMMMoooo..oooo",
		          "...ofooohhoooo..",
		          ".ofoofooooohhoo.",
		          "...ooo..........",
		          ".ooooo.ooohooM..",
		          ".ooooo.oohooof..",
		          "offfoooo.offoooo",
		          "oooooooo...ooooo",
		          ".ooMMMoooo......",
		          "..ooooooffoooo..",
		          "....ooooooooo...",
		          "..ooohhoo.......",
		          ".....ooooooooo..",
		};
		String line;
	    for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
	      line = layout[r];
	      for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
	        char tileChar = line.charAt(c);
	        String type = "error";
	        if ( tileChar == '.' ) { type = GameConstants.OCEANS; }
	        if ( tileChar == 'o' ) { type = GameConstants.PLAINS; }
	        if ( tileChar == 'M' ) { type = GameConstants.MOUNTAINS; }
	        if ( tileChar == 'f' ) { type = GameConstants.FOREST; }
	        if ( tileChar == 'h' ) { type = GameConstants.HILLS; }
	        Position p = new Position(r,c);
	        world.put( p, new TileImpl(type));
	      }
	    }
		return world;
	}

}
