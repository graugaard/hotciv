package hotciv.strategy;

import java.util.*;

import hotciv.framework.City;
import hotciv.framework.ExtendedGame;
import hotciv.framework.Position;
import hotciv.framework.ProductionTable;
import hotciv.framework.Tile;
import hotciv.strategy.utilities.FoodComparator;
import hotciv.strategy.utilities.ProductionStack;

public class EtaProduction implements ProductionStrategy {

	@Override
	public ProductionStack produce(ExtendedGame g, Position p) {
		int food = 1, production = 1;
		City c = g.getCityAt(p);
		if( c.getSize() > 1) {
			List<Position> positions = g.getPositions(p, 1);
			List<Tile> tiles = new ArrayList<Tile>();
			for (Position pos : positions) {
				tiles.add(g.getTileAt(pos));
			}
			Collections.sort(tiles, new FoodComparator());
			for (int i = 0; i < 2; i++) {
				Tile t = tiles.get(i);
				food += ProductionTable.food(t.getTypeString());
				production += ProductionTable.production(t.getTypeString());
			}
		}
		return new ProductionStack(food, production);
	}

}
