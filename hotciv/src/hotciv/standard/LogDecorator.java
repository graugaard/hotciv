package hotciv.standard;

import hotciv.common.GameImpl;
import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.strategy.AgeStrategy;

public class LogDecorator implements Game{
	
	private Game game;
	private String log;
	
	public LogDecorator(Game gm){
		game = gm;		
		log = "The game begins.\n";
	}
	
	
	@Override	
	public Tile getTileAt(Position p) {
		return game.getTileAt(p);
	}

	@Override
	public Unit getUnitAt(Position p) {
		return game.getUnitAt(p);
	}

	@Override
	public City getCityAt(Position p) {
		return game.getCityAt(p);
	}

	@Override
	public Player getPlayerInTurn() {
		return game.getPlayerInTurn();
	}

	@Override
	public Player getWinner() {
		if (getWinner()!= null){
			log += "" + getWinner() + " has won the game.";
		}
		return game.getWinner();
	}

	@Override
	public int getAge() {
		return game.getAge();
	}

	@Override
	public boolean moveUnit(Position from, Position to) {
		log += "" + getPlayerInTurn() + " moves " + getUnitAt(from).getTypeString() + " from " + from + " to " + to + ".\n";
		return game.moveUnit(from, to);
		
	}

	@Override
	public void endOfTurn() {
		log += "" + getPlayerInTurn() + " ends turn.\n";
		game.endOfTurn();
		
	}

	@Override
	public void changeWorkForceFocusInCityAt(Position p, String balance) {
		String workForce;
		if (balance == "hammer") {
			workForce = "productionFocus";
		}
		else {
			workForce = "foodFocus";
			}
		log += "" + getPlayerInTurn() + " changes work force focus in city at " + p + " to " + workForce + ".\n";
		game.changeWorkForceFocusInCityAt(p, balance);		
	}

	@Override
	public void changeProductionInCityAt(Position p, String unitType) {
		log += "" + getPlayerInTurn() + " changes production in city at " + p + " to " + unitType + ".\n";
		game.changeProductionInCityAt(p, unitType);
		
	}

	@Override
	public void performUnitActionAt(Position p) {
		log += "" + getPlayerInTurn() + " performs unit action on " + getUnitAt(p).getTypeString() + " at " + p + ".\n";
		game.performUnitActionAt(p);
		
	}

	@Override
	public int dist(Position p1, Position p2) {
		return game.dist(p1, p2);
	}

	@Override
	public void setAgeStrategy(AgeStrategy useThisStrategy) {
		game.setAgeStrategy(useThisStrategy);
		
	}
	public String getLog(){
		return log;
	}

}
