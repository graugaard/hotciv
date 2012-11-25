package hotciv.standard;

import hotciv.common.CityImpl;
import hotciv.common.TileImpl;
import hotciv.common.UnitImpl;
import hotciv.framework.*;
public class AlphaWorldGeneration implements WorldGeneration{


    public int getWorldHeight() {
        return GameConstants.WORLDSIZE;
    }

    public int getWorldWidth() {
        return GameConstants.WORLDSIZE;
    }

    public Tile[][] generateTiles() {
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

    public City[][] generateCities() {
        int worldSize = GameConstants.WORLDSIZE;
        City[][] cities = new City[worldSize][worldSize];
        cities[1][1] = new CityImpl(Player.RED);
        cities[4][1] = new CityImpl(Player.BLUE);
        return cities;
    }

    public Unit[][] generateUnits() {
        int worldSize = GameConstants.WORLDSIZE;
        Unit[][] units = new Unit[worldSize][worldSize];
        units[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED);
        units[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED);
        units[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE);
        return units;
    }
}
