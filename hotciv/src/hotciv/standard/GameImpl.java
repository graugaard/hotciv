package hotciv.standard;

import java.util.*;

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
    private boolean firstRound;
    private AgeStrategy ageStrategy;
    private WinnerStrategy winnerStrategy;

    /**
     * Make a new Alphaciv game, fresh to be used
     */
    public GameImpl(GameFactory factory) {
        int wSize = GameConstants.WORLDSIZE;
        setupUnits(wSize);
        setupTiles(wSize);
        setupCities(wSize);
        playerInTurn = Player.RED;
        age = -4000;
        firstRound = true;
        this.ageStrategy = factory.makeAgeStrategy();
        this.winnerStrategy = factory.makeWinnerStrategy();
    }

    public void setAgeStrategy(AgeStrategy useThisStrategy){
        ageStrategy = useThisStrategy;

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
        return winnerStrategy.getWinner(this);
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
            if(!firstRound)
                produce(Player.BLUE);
        }
        else {
            playerInTurn = Player.RED;
            age = ageStrategy.calculateNextAge(age);
            produce(Player.RED);
            resetMove();
            firstRound = false;
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
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                cities[i][j] = null;
            }
        }
        cities[1][1] = new CityImpl(Player.RED);
        cities[4][1] = new CityImpl(Player.BLUE);

    }

    private void produce(Player p) {
        int ws = GameConstants.WORLDSIZE;
        for(int i = 0; i< ws; i++) {
            for(int j = 0; j < ws; j++) {
                City c =  getCityAt(new Position(i,j));
                if (c != null && c.getOwner() == p) {
                    c.addProduction(6);
                    String prod = c.getProduction();
                    if(c.getProductionValue() >= unitCost(prod)){
                        setUnit(new UnitImpl(prod, p), new Position(i,j));
                        c.addProduction(-unitCost(prod));
                    }
                }
            }
        }
    }
    private int unitCost(String type) {
        if (type.equals(GameConstants.ARCHER)) {
            return 10;
        }
        else if (type.equals(GameConstants.LEGION)) {
            return 15;
        }
        else return 30;
    }
    
    /* Sets the unit at first available position. Returns true if
     * unit could be set
     */
    private boolean setUnit(Unit u, Position center) {
    	int dist = 0; // we first check if unit can be placed in city
    	boolean unitSet = false;
    	// once dist is greater than how big the world is, we can't find anymore positions
    	while(dist <= GameConstants.WORLDSIZE && !unitSet) {
    		List<Position> positions = getPositions(center, dist);
    		for (Position p : positions) {
    			if (getUnitAt(p) == null) {
    				units[p.getRow()][p.getColumn()] = u;
    				unitSet = true;
    				break; // unit has been set, no need to loop anymore
    			}
    		}
    		// could find empty position in current distance, expand search
    		dist++;
    	}
    	return unitSet;
    }
    /**
     * Return a list of valid game positions that is the specified
     * distance away from the center. They are ordered by the position due north
     * is the first in the list and they come clockwise
     * Precondition: center is a valid position in world
     * @param center The center from which we measure the distance
     * @param dist The distance away from the center we retrieve the positions, must be 0 or greater
     * @return The list of positions, ordered by starting due north and going around clockwise.
     * @return The list has size 0 if no such positions exist.
     */
    public List<Position> getPositions(Position center, int dist) {
    	List<Position> result = new ArrayList<Position>();
    	/* Start at position due north that is distance dist away.
    	 * Add it and continue counter clockwise to add positions.
    	 * Stop when we are back at position due north
    	 */
    	if (dist == 0) {
    		result.add(center);
    	}
    	else if (dist > 0) {
    		int x = center.getRow();
    		int y = center.getColumn();
    		/* Before we enter a loop, check that the coordinate we fix
    		 * will lie inside the world. We use that x and y already are
    		 * valid positions
    		 */
    		int ws = GameConstants.WORLDSIZE;
    		if (x - dist >= 0) {
    			for (int i = y; i < y+dist && i < ws; i++) {
    				result.add(new Position(x-dist,i));
    			}
    		}
    		if (y + dist < ws) {
    			// if x - dist < 0, start from where we enter world again
    			int xStart = Math.max(0, x-dist);
    			for (int i = xStart; i < x+dist && i < ws; i++) {
    				result.add(new Position(i,y+dist));
    			}
    		}
    		if (x + dist < ws) {
    			// if y + dist >= worldsize, start from when enter world again
    			int yStart = Math.min(ws - 1, y + dist);
    			for (int i = yStart; i > y-dist && i >= 0; i--){
    				result.add(new Position(x+dist,i));
    			}
    		}
    		if (y - dist >= 0) {
    			// start from when the world exists
    			int xStart = Math.min(ws - 1, x + dist);
    			for (int i = xStart; i > x-dist && i >= 0; i--) {
    				result.add(new Position(i,y-dist));
    			}
    			for (int i = y-dist; i < y; i++) {
    				result.add(new Position(x-dist,i));
    			}
    		}
    	}
    	return result;
    }
}
