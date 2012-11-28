package hotciv.strategy;

import hotciv.framework.ExtendedGame;
import hotciv.framework.Position;


/**
 * This thing relates to attacks
 * @author jakob
 *
 */
public interface AttackStrategy {
	
	/**
	 * Attack defender.
	 * Precondition: Both positions are occupied by a unit
	 * @param attacker The one who attacks
	 * @param defender The one who is being attacked
	 * @return Return true if and only if the attacker wins
	 */
	public boolean attack(ExtendedGame game, Position attacker, 
			Position defender);
}
