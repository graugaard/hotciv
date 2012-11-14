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
    private City[][] cities;
    private Player playerInTurn;
    private int age;

    /**
     * Make a new Alphaciv game, fresh to be used
     */
    public GameImpl() {
        int wSize = GameConstants.WORLDSIZE;
        setupUnits(wSize);
        setupTiles(wSize);
        setupCities(wSize);
        playerInTurn = Player.RED;
        age = -4000;
    }


    public Tile getTileAt( Position p ) {
        return tiles[p.getRow()][p.getColumn()];
    }
    public Unit getUnitAt( Position p ) {
        return units[p.getRow()][p.getColumn()];
    }
    public City getCityAt( Position p ) {
        return cities[p.getRow()][p.getColumn()];
    }
    public Player getPlayerInTurn() { return playerInTurn; }
    public Player getWinner() {
        if(age==-3000)
            return Player.RED;
        else return null;
    }
    public int getAge() { return age; }
    public boolean moveUnit( Position from, Position to ) {
        Unit u = getUnitAt(from);
        if (u != null) {
            if (dist(from,to) > u.getMoveCount())
                return false;
            else if (u.getOwner() != playerInTurn)
                return false;
            else if (getUnitAt(to) != null && getUnitAt(to).getOwner() == u.getOwner())
                return false;

            else {
                u.setMoveCount(0);
                units[to.getRow()][to.getColumn()] = u;
                units[from.getRow()][from.getColumn()] = null;
                return true;
            }
        }
        else return false;
    }
    public void endOfTurn() {
        if (playerInTurn == Player.RED) {
            playerInTurn = Player.BLUE;
        }
        else {
            playerInTurn = Player.RED;
            age += 100;
            resetMove();
        }
    }
    public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
    public void changeProductionInCityAt( Position p, String unitType ) {
        City c = getCityAt(p);
        c.setProduction(unitType);

    }
    public void performUnitActionAt( Position p ) {}
    public int dist(Position p1, Position p2) {
        int x = Math.abs(p1.getRow()-p2.getRow());
        int y = Math.abs(p1.getColumn() - p2.getColumn());
        return Math.max(x,y);
    }
    //used to reset all units movevalue at the beginning of a new round
    public void resetMove(){
        int size = GameConstants.WORLDSIZE;
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                if (units[i][j]!= null)
                    units[i][j].setMoveCount(1);

    }

    // setup the game world tiles
    private void setupTiles(int worldSize) {
        tiles = new Tile[worldSize][worldSize];
        for(int i = 0; i < worldSize; i++)
            for(int j = 0; j < worldSize; j++)
                tiles[i][j] = new TileImpl(GameConstants.PLAINS);
        // special tiles, since most is plains
        tiles[1][0] = new TileImpl(GameConstants.OCEANS);
        tiles[0][1] = new TileImpl(GameConstants.HILLS);
        tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
    }
    // set up the initial units at in the game
    private void setupUnits(int worldSize) {
        units = new Unit[worldSize][worldSize];
        for (int i = 0; i < worldSize; i++)
            for(int j = 0; j < worldSize; j++)
                units[i][j] = null;
        units[4][3] = new UnitImpl(GameConstants.SETTLER,
                Player.RED);
        units[2][0] = new UnitImpl(GameConstants.ARCHER,
                Player.RED);
        units[3][2] = new UnitImpl(GameConstants.LEGION,
                Player.BLUE);
    }
    // set up the initial cities in the game
    private void setupCities(int worldSize) {
        cities = new City[worldSize][worldSize];
        for (int i = 0; i < worldSize; i++)
            for (int j = 0; j < worldSize; j++)
                cities[i][j] = null;
        cities[1][1] = new CityImpl(Player.RED);
        cities[4][1] = new CityImpl(Player.BLUE);

    }
}
