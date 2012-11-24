package hotciv.framework;


/**
 * This thing relates to attacks
 * @author jakob
 *
 */
public interface AttackStrategy {
	/**
	 * Return how many successful attacks the player
	 * has have
	 * @param p The player we want to know about
	 * @return how many successful attacks the player have performed
	 */
	public int getSuccessfulAttacks(Player p);
	
	/**
	 * Perform the attack. WARNING! this changes the internal
	 * state of the object.
	 * @param attacker The one who attacks
	 * @param defender The one who is being attacked
	 * @return Which position had the victor
	 */
	public Position performAttack(Position attacker, 
			Position defender);
}
