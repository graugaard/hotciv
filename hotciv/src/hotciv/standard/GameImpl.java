package hotciv.standard;

import hotciv.framework.*;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
*/

public class GameImpl implements Game {

    private Unit[][] units;
    private Tile[][] tiles;

    /**
     * Make a new Alphaciv game, fresh to be used
     */
    public GameImpl() {
        int wSize = GameConstants.WORLDSIZE;
        setupUnits(wSize);
        setupTiles(wSize);
    }

    // setup the game world tiles
    private void setupTiles(int worldSize) {
        tiles = new Tile[worldSize][worldSize];
        for(int i = 0; i < worldSize; i++)
            for(int j = 0; j < worldSize; j++)
                tiles[i][j] = new TileImpl(GameConstants.PLAINS);
        tiles[1][0] = new TileImpl(GameConstants.OCEANS);
        tiles[0][1] = new TileImpl(GameConstants.HILLS);
        tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
    }
    // set up the initial units at in the game
    private void setupUnits(int worldSize) {
        units = new Unit[worldSize][worldSize];
        units[4][3] = new UnitImpl(GameConstants.SETTLER,
                Player.RED);
        units[2][0] = new UnitImpl(GameConstants.ARCHER,
                Player.RED);
        units[3][2] = new UnitImpl(GameConstants.LEGION,
                Player.BLUE);
    }
    public Tile getTileAt( Position p ) {
        return tiles[p.getRow()][p.getColumn()];
  }
  public Unit getUnitAt( Position p ) {
      return units[p.getRow()][p.getColumn()];
  }
  public City getCityAt( Position p ) {
      if(p.getColumn()==1 && p.getRow() == 1)
          return new CityImpl(Player.RED);
      if(p.getColumn() == 1 && p.getRow() == 4)
          return new CityImpl(Player.BLUE);
      else return null;
  }
  public Player getPlayerInTurn() { return null; }
  public Player getWinner() { return null; }
  public int getAge() { return 0; }
  public boolean moveUnit( Position from, Position to ) {
    return false;
  }
  public void endOfTurn() {}
  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}
}
