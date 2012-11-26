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
	
	ExtendedGame g;
	WorldGeneration wg;
	FixedDie fixedDie;
	EpsilonAttack ea;
	String[] t = { ".....", ".....", ".....", "....." };
	String[] c = t;
	String[] u = { 	".ALS.", 
					"laS..", 
					"sslLA", 
					"....." };

	@Before
	public void setUp() {
		wg = new StringWorldGeneration( t, c, u);
		ExtendedGame g = new GameImpl( new AlphaFactory(), wg );
		FixedDie d = new FixedDie(1);
		ea = new EpsilonAttack( g, d );
	}
	@Test
	public void ShouldGetCorrectAtckAdjacencyBonus() {
		
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

	@Test
	public void ShouldGrantTerrainAtckBonus1WhenForestOrHills() {
		String[] tiles = { 	".fffhhh.",
							".fffhhh." };
		String[] cities = {	"........",
							"........" };
		String[] units = {	"AALSALSA",
							"aalsalsa" };
		wg = new StringWorldGeneration( tiles, cities, units );
		g = new GameImpl( new AlphaFactory(), wg);
		ea = new EpsilonAttack(g, fixedDie);
		Position p0 = new Position(0,1);
		System.out.println(g.getTileAt(p0).getTypeString());
		assertEquals( "Unit at (0,1) has atkStr 8 " +
				"(2 tBonus*(2 atk + 2adjBonus)",
				8, ea.modifiedAttack( p0 ));
		
		Position p1 = new Position( 1, 2 );
		assertEquals( "Unit at (1,2) has atkStr 12 " +
				"(2 tBonus*(4 atk + 2adjBonus)",
				12, ea.modifiedAttack( p1 ));
		
		Position p2 = new Position(0,3);
		assertEquals( "Unit at (1,3) has atkStr 4 " +
				"(2 tBonus*(0 atk + 2adjBonus)",
				4, ea.modifiedAttack( p2 ));
		
		Position p3 = new Position(1,4);
		assertEquals( "Unit at (1,4) has atkStr 8 " +
				"(2 tBonus*(2 atk + 2adjBonus)",
				8, ea.modifiedAttack( p3 ));
		
		Position p4 = new Position(0,5);
		assertEquals( "Unit at (0,5) has atkStr 12 " +
				"(2 tBonus*(4 atk + 2adjBonus)",
				12, ea.modifiedAttack( p4 ));
		
		Position p5 = new Position(1,6);
		assertEquals( "Unit at (1,6) has atkStr 4 " +
				"(2 tBonus*(0 atk + 2adjBonus)",
				4, ea.modifiedAttack( p5 ));

	}
}
