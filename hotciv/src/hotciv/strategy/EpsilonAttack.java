package hotciv.strategy;

import hotciv.framework.ExtendedGame;
import hotciv.framework.Position;

public class EpsilonAttack implements AttackStrategy {
	
	ExtendedGame game;
	DieRoller die;
	public EpsilonAttack( ExtendedGame game, DieRoller die ) {
		this.game = game;
		this.die = die;
	}
	
	public boolean attack( Position attacker, Position defender ) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int modifiedDefence( Position defender ) {
		return 0;
	}
	
	public int modifiedAttack( Position attacker ) {
		return 0;
	}
}
