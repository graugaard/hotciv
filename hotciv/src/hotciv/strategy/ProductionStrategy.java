package hotciv.strategy;

import hotciv.framework.*;
import hotciv.strategy.utilities.ProductionStack;

public interface ProductionStrategy {
	/**
	 * Will give how much food and production a city gets
	 * Precondition: There is a city at p
	 * @param g The game
	 * @param p The position of the city
	 * @return Food and production the city gets
	 */
	public ProductionStack produce(ExtendedGame g, Position p);
}
