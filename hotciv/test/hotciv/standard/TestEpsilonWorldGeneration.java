package hotciv.standard;

import hotciv.framework.*;
import hotciv.common.*;

public class TestEpsilonWorldGeneration implements WorldGeneration {
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
        return new City[0][0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Unit[][] generateUnits() {
        Unit[][] units = new Unit[getWorldWidth()][getWorldHeight()];
        units[2][3] = new UnitImpl(GameConstants.ARCHER, Player.RED);
        units[6][5] = new UnitImpl(GameConstants.ARCHER, Player.RED);
        units[11][14] = new UnitImpl(GameConstants.ARCHER, Player.RED);
        units[2][4] = new UnitImpl(GameConstants.ARCHER, Player.BLUE);
        units[5][5] = new UnitImpl(GameConstants.ARCHER, Player.BLUE);
        units[12][13] = new UnitImpl(GameConstants.ARCHER, Player.BLUE);

        return units;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
