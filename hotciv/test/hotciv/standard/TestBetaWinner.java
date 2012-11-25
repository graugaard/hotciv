package hotciv.standard;

import hotciv.common.CityImpl;
import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.strategy.AgeStrategy;
/**
 * This is a barebones city impl. All that happens is that red owns all cities.
 * @author jakob
 *
 */
public class TestBetaWinner implements Game {

	@Override
	public Tile getTileAt(Position p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit getUnitAt(Position p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City getCityAt(Position p) {
		// TODO Auto-generated method stub
		return new CityImpl(Player.RED);
	}

	@Override
	public Player getPlayerInTurn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean moveUnit(Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void endOfTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeWorkForceFocusInCityAt(Position p, String balance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeProductionInCityAt(Position p, String unitType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void performUnitActionAt(Position p) {
		// TODO Auto-generated method stub

	}

	@Override
	public int dist(Position p1, Position p2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAgeStrategy(AgeStrategy useThisStrategy) {
		// TODO Auto-generated method stub

	}

}
