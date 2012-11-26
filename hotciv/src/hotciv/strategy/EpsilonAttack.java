package hotciv.strategy;

import java.util.List;

import hotciv.framework.ExtendedGame;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

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
		Unit u = game.getUnitAt( defender );
		return u.getDefensiveStrength() + adjBonus( defender, u );
	}
	
	public int modifiedAttack( Position attacker ) {
		Unit u = game.getUnitAt( attacker );
		int terrainBonus = 1;
		Tile t = game.getTileAt( attacker );
		String terrainType = t.getTypeString();
		if ( terrainType.equals( GameConstants.HILLS) || 
				terrainType.equals( GameConstants.FOREST) ) {
			terrainBonus = 2;
		}
		return terrainBonus*( u.getAttackingStrength() + 
				adjBonus( attacker, u ) );
	}
	
	private int adjBonus( Position p, Unit u) {
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
}
