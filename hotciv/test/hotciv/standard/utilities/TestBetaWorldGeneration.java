package hotciv.standard.utilities;

import hotciv.common.CityImpl;
import hotciv.common.TileImpl;
import hotciv.framework.*;

public class TestBetaWorldGeneration implements WorldGeneration{

    @Override
    public int getWorldHeight() {
        return GameConstants.WORLDSIZE;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getWorldWidth() {
        return GameConstants.WORLDSIZE;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Tile[][] generateTiles() {
        Tile[][] tiles =
                new Tile[getWorldWidth()][getWorldHeight()];
        for (int i = 0; i < getWorldWidth(); i++) {
            for (int j = 0; j < getWorldHeight(); j++){
                tiles[i][j] = new TileImpl(GameConstants.PLAINS);
            }
        }
        return tiles;
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public City[][] generateCities() {
        City[][] cities = new City[getWorldWidth()][getWorldHeight()];
        cities[1][1] = new CityImpl(Player.RED);
        cities[4][1] = new CityImpl(Player.RED);
        return cities;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Unit[][] generateUnits() {
        return new Unit[0][];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
