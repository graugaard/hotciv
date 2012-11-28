package hotciv.strategy;

import hotciv.framework.ExtendedGame;
import hotciv.framework.Position;

public class AlphaAttack implements AttackStrategy {

	public boolean attack( ExtendedGame game, Position attacker, Position defender) {
		return true;
	}

}
