package hotciv.strategy;

import hotciv.framework.ExtendedGame;
import hotciv.framework.Position;
import hotciv.strategy.utilities.ProductionStack;

public class AlphaProduction implements ProductionStrategy {

	@Override
	public ProductionStack produce(ExtendedGame g, Position p) {
		return new ProductionStack(0,6);
	}

}
