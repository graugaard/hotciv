package hotciv.strategy;

import hotciv.framework.Position;


/**
 * This thing relates to attacks
 * @author jakob
 *
 */
public interface AttackStrategy {
	
	/**
	 * Attack defender.
	 * @param attacker The one who attacks
	 * @param defender The one who is being attacked
	 * @return Return true if and only if the attacker wins
	 */
	public boolean attack(Position attacker, 
			Position defender);
}
