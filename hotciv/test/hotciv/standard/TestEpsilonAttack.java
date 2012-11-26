package hotciv.standard;

import hotciv.common.GameImpl;
import hotciv.factories.AlphaFactory;
import hotciv.framework.ExtendedGame;
import hotciv.framework.Position;
import hotciv.framework.WorldGeneration;
import hotciv.standard.utilities.StringWorldGeneration;
import hotciv.strategy.EpsilonAttack;

import org.junit.*;
import static org.junit.Assert.*;

public class TestEpsilonAttack {

	@Test
	public void ShouldGetCorrectAtckAdjacencyBonus() {
		String[] t = { ".....", ".....", ".....", "....." };
		String[] c = t;
		String[] u = { 	".ALS.", 
						"laS..", 
						"sslLA", 
						"....." };
		WorldGeneration wg = new StringWorldGeneration( t, c, u );
		ExtendedGame g = new GameImpl( new AlphaFactory(), wg );
		FixedDie d = new FixedDie(1);
		EpsilonAttack ea = new EpsilonAttack( g, d );
		
		Position p1 = new Position( 0, 2 );
		assertEquals( "Red legion at (0,2) should have modified " +
				"attack strength 7 (4 + 3 bonus)",
				7, ea.modifiedAttack( p1 ));
		
		Position p2 = new Position( 1, 1 );
		assertEquals( "Blue archer at (1,1) should have modifed " +
				"attack strength 6 (2 + 4 bonus)",
				6, ea.modifiedAttack( p2 ) );
		
		Position p3 = new Position( 1,2 );
		assertEquals( "Red settler at (1,2) should have modified " +
				"attackStrength 4 (0 + 4 bonus)",
				4, ea.modifiedAttack( p3 ));
	}
	
	@Test
	public void ShouldGetCorrectDefAdjBonus() {
		String[] t = { ".....", ".....", ".....", "....." };
		String[] c = t;
		String[] u = { 	".ALS.", 
						"laS..", 
						"sslLA", 
						"....." };
		WorldGeneration wg = new StringWorldGeneration( t, c, u );
		ExtendedGame g = new GameImpl( new AlphaFactory(), wg );
		FixedDie d = new FixedDie(1);
		EpsilonAttack ea = new EpsilonAttack( g, d );
		
		Position p1 = new Position( 0, 2 );
		assertEquals( "Red legion at (0,2) should have modified " +
				"defence strength 5 (2 + 3 bonus)",
				5, ea.modifiedDefence( p1 ));
		
		Position p2 = new Position( 1, 1 );
		assertEquals( "Blue archer at (1,1) should have modifed " +
				"defence strength 7 (3 + 4 bonus)", 
				7, ea.modifiedDefence( p2 ) );
		
		Position p3 = new Position( 1,2 );
		assertEquals( "Red settler at (1,2) should have modified " +
				"attackStrength 7 (3 + 4 bonus)",
				7, ea.modifiedDefence( p3 ));
	}
}
