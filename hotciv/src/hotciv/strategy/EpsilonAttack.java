package hotciv.strategy;

import java.util.List;

import hotciv.framework.ExtendedGame;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

public class EpsilonAttack implements AttackStrategy {
	DieRoller die;
	public EpsilonAttack(  DieRoller die ) {
		this.die = die;
	}
	
	public boolean attack( ExtendedGame game, Position attacker, Position defender ) {
		int d1 = die.rollDie();
		int d2 = die.rollDie();
		int atk = modifiedAttack( game, attacker );
		int def = modifiedDefence( game, defender );
		return d1 * atk > d2 * def;
	}
	
	public int modifiedDefence( ExtendedGame game, Position defender ) {
		Unit u = game.getUnitAt( defender );
		int terBonus = terrainBonus( game, defender );
		int adjBonus = adjBonus( game, defender, u );
		return terBonus*( u.getDefensiveStrength() + adjBonus );
	}
	
	public int modifiedAttack( ExtendedGame game, Position attacker ) {
		Unit u = game.getUnitAt( attacker );
		int terBonus = terrainBonus( game, attacker );
		int adjBonus = adjBonus( game, attacker, u );
		return terBonus*( u.getAttackingStrength() + adjBonus );
	}
	
	private int adjBonus( ExtendedGame game, Position p, Unit u) {
		List<Position> adjPositions = game.getPositions( p, 1 );
		int bonus = 0;
		for ( Position pos : adjPositions) {
			Unit adjU = game.getUnitAt( pos );
			if ( adjU != null && u.getOwner() == adjU.getOwner() ) {
				bonus++;
			}
		}
		return bonus;
	}
	
	private int terrainBonus( ExtendedGame game, Position p ) {
		int bonus = 1; // default value
		Tile t = game.getTileAt(p);
		String terrainType = t.getTypeString();
		// cities grant terrain bonus first
		if ( game.getCityAt(p) != null ) {
			bonus = 3;
		} else if ( terrainType.equals(GameConstants.FOREST) ||
				terrainType.equals(GameConstants.HILLS)) {
			bonus = 2;
		}
		return bonus;
	}
}
