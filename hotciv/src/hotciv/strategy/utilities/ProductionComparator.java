package hotciv.strategy.utilities;

import hotciv.framework.ProductionTable;
import hotciv.framework.Tile;

import java.util.Comparator;

public class ProductionComparator implements Comparator<Tile> {

	@Override
	public int compare(Tile t1, Tile t2) {
		int p1 = 
				ProductionTable.production(t1.getTypeString());
		int p2 =
				ProductionTable.production(t2.getTypeString());
		
		int f1 = ProductionTable.food(t1.getTypeString());
		int f2 = ProductionTable.food(t2.getTypeString());
		
		if ( p1 - p2 == 0) {
			return f2 - f1;
		}
		return p2 - p1;
	}

}
