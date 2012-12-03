package hotciv.strategy;

import java.util.*;

import hotciv.framework.City;
import hotciv.framework.ExtendedGame;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.ProductionTable;
import hotciv.framework.Tile;
import hotciv.strategy.utilities.FoodComparator;
import hotciv.strategy.utilities.ProductionComparator;
import hotciv.strategy.utilities.ProductionStack;

public class EtaProduction implements ProductionStrategy {

	@Override
	public ProductionStack produce(ExtendedGame g, Position p) {
		int food = 0, production = 0;
		City c = g.getCityAt(p);
		List<Position> positions;
		int dist = 0;
		int remPop = c.getSize();
		while (remPop > 0) {
			if ( dist == 0) {
				food +=1;
				production += 1;
				remPop--;
			}
			else {
				positions = g.getPositions(p, dist);
				remPop -= positions.size();
				int fieldsToBeWorked;
				if (remPop > 0) {
					fieldsToBeWorked = positions.size();
				}
				else {
					fieldsToBeWorked = remPop + positions.size(); // add back what we list
				}
				ProductionStack s = 
						produceCircle(g, positions, fieldsToBeWorked, c);
				food += s.getFood();
				production += s.getProduction();	
			}
			dist++;
		}
		return new ProductionStack(food, production);
	}

	private ProductionStack produceCircle(ExtendedGame g, List<Position> positions, int size, City c) {
		List<Tile> tiles = new ArrayList<Tile>();
		int food = 0;
		int production = 0;
		for (Position pos : positions) {
			tiles.add(g.getTileAt(pos));
		}
		if (c.getWorkforceFocus().equals(GameConstants.foodFocus)) {
			Collections.sort(tiles, new FoodComparator());
		}
		else {
			Collections.sort(tiles, new ProductionComparator());
		}
		for (int i = 0; i < size; i++) {
			Tile t = tiles.get(i);
			food += ProductionTable.food(t.getTypeString());
			production += ProductionTable.production(t.getTypeString());
		}
		return new ProductionStack(food, production);
	}

}
