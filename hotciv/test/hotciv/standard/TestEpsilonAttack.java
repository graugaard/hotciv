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
	String[] t1 = { ".....", ".....", ".....", "....." };
	String[] c1 = t1;
	String[] u1 = { ".ALS.", 
					"laS..", 
					"sslLA", 
					"....." };
	
	String[] tiles = { 	".fffhhh.",
						".fffhhh." };
	String[] cities = {	"........",
						"........" };
	String[] units = {	"AALSALSA",
						"aalsalsa" };

	@Before
	public void setUp() {
		wg = new StringWorldGeneration( t1, c1, u1);
		ExtendedGame g = new GameImpl( new AlphaFactory(), wg );
		fixedDie = new FixedDie( 1, 1 );
		ea = new EpsilonAttack( g, fixedDie );
	}
	
	@Test
	public void ShouldHaveFixedDieBehavesCorrectly() {
		fixedDie = new FixedDie( 1, 2 );
		assertEquals( "First roll is 1", 1, fixedDie.rollDie() );
		assertEquals( "Second roll is 2", 2, fixedDie.rollDie() );
		assertEquals( "Third roll is 1", 1, fixedDie.rollDie() );
		assertEquals( "Fourth roll is 2", 2, fixedDie.rollDie() );
		
		// test we can change the rolls.
		fixedDie.setRoll1( 4 );
		fixedDie.setRoll2( 3 );
		assertEquals( "First roll is 4", 4, fixedDie.rollDie() );
		assertEquals( "Second roll is 3", 3, fixedDie.rollDie() );
		assertEquals( "Third roll is 4", 4, fixedDie.rollDie() );
		assertEquals( "Fourth roll is 3", 3, fixedDie.rollDie() );
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
	public void ShouldGrantTerrainAtckBonusOF2WhenForestOrHills() {
		
		wg = new StringWorldGeneration( tiles, cities, units );
		g = new GameImpl( new AlphaFactory(), wg);
		ea = new EpsilonAttack(g, fixedDie);
		
		/*
		 * In the following, we use the formula
		 * atkStr = terrainBonus * (unit Attack Strength + adj Bonus)
		 * forest and hill grant a terrain bonus of 2
		 */
		Position p0 = new Position(0,1);
		assertEquals( "Unit at (0,1) has atkStr 8 " +
				"(2 tBonus*(2 atk + 2adjBonus)",
				8, ea.modifiedAttack( p0 ));
		
		Position p1 = new Position( 1, 2 );
		assertEquals( "Unit at (1,2) has atkStr 12",
				12, ea.modifiedAttack( p1 ));
		
		Position p2 = new Position(0,3);
		assertEquals( "Unit at (1,3) has atkStr 4",
				4, ea.modifiedAttack( p2 ));
		
		Position p3 = new Position(1,4);
		assertEquals( "Unit at (1,4) has atkStr 8",
				8, ea.modifiedAttack( p3 ));
		
		Position p4 = new Position(0,5);
		assertEquals( "Unit at (0,5) has atkStr 12",
				12, ea.modifiedAttack( p4 ));
		
		Position p5 = new Position(1,6);
		assertEquals( "Unit at (1,6) has atkStr 4",
				4, ea.modifiedAttack( p5 ));

	}
	@Test
	public void ShouldGrantTerrainDefBonusOf2WhenForestOrHills() {
		
		wg = new StringWorldGeneration( tiles, cities, units );
		g = new GameImpl( new AlphaFactory(), wg);
		ea = new EpsilonAttack(g, fixedDie);
		
		/*
		 * In the following, we use the formula
		 * defStr = terrainBonus * (unit Defensive Strength + adj Bonus)
		 * forest and hill grant a terrain bonus of 2
		 */
		
		Position p0 = new Position(0,1);
		assertEquals( "Unit at (0,1) has defStr 10",
				10, ea.modifiedDefence( p0 ));
		
		Position p1 = new Position( 1, 2 );
		assertEquals( "Unit at (1,2) has defStr 8",
				8, ea.modifiedDefence( p1 ));
		
		Position p2 = new Position(0,3);
		assertEquals( "Unit at (1,3) has defStr 10",
				10, ea.modifiedDefence( p2 ));
		
		Position p3 = new Position(1,4);
		assertEquals( "Unit at (1,4) has defStr 8",
				10, ea.modifiedDefence( p3 ));
		
		Position p4 = new Position(0,5);
		assertEquals( "Unit at (0,5) has defStr 8",
				8, ea.modifiedDefence( p4 ));
		
		Position p5 = new Position(1,6);
		assertEquals( "Unit at (1,6) has defStr 10",
				10, ea.modifiedDefence( p5 ));

	}
	
	@Test
	public void ShouldGrantAtkAndDefBonusOf3WhenInCity () {
		String[] c = {  "R.RRR...",
						"B.BBB..."};
		wg = new StringWorldGeneration( tiles, c, units );
		g = new GameImpl( new AlphaFactory(), wg );
		ea = new EpsilonAttack( g, fixedDie );
		/*
		 * In the following, we use the formulas
		 * atkStr = terrainBonus * (unit Attack Strength + adj Bonus)
		 * defStr = terrainBonus * (unit Defensive Strength + adj Bonus)
		 * cities grant a terrain bonus of 3
		 */
		Position p0 = new Position( 0, 0 );
		assertEquals( "Unit at (0,1) has modified atkStr 9",
				9, ea.modifiedAttack( p0 ));
		assertEquals( "Unit at (0,1) has modified defStr 12 ",
				12, ea.modifiedDefence( p0 ));
		
		Position p1 = new Position( 0, 2 );
		assertEquals( "Unit at (0,2) has modified atkStr 18",
				18, ea.modifiedAttack( p1 ));
		assertEquals( "Unit at (0,2) has modified defStr 12 ",
				12, ea.modifiedDefence( p1 ));
		
		Position p2 = new Position( 1, 3 );
		assertEquals( "Unit at (1,3) has modified atkStr 6",
				6, ea.modifiedAttack( p2 ));
		assertEquals( "Unit at (1,3) has modified defStr 15 ",
				15, ea.modifiedDefence( p2 ));
	}
	
	@Test
	public void ShouldGiveCorrectWinnerWhenRollingDies() {
		wg = new StringWorldGeneration( tiles, cities, units );
		g = new GameImpl( new AlphaFactory(), wg );
		ea = new EpsilonAttack( g, fixedDie );
		
		Position atk0 = new Position( 0, 1 ); // atk is 8
		Position def0 = new Position( 1, 2 ); // def is 8
		assertFalse( "attacker lose when def = atk, " +
				"modified by die roll", ea.attack(atk0, def0));
		
		Position atk1 = def0; // def is 10
		Position def1 = atk0; // atk is 12
		assertTrue( "attacker win when def < atk, " +
				"modified by die roll", ea.attack(atk1, def1));
		fixedDie.setRoll1( 4 );
		fixedDie.setRoll2( 3 );
		// 4*10 > 3*10
		assertTrue( "attacker win when def < atk, " +
				"modified by die roll", ea.attack(atk0, def0));
		
		fixedDie.setRoll1( 3 );
		fixedDie.setRoll2( 4 );
		// 4*10 > 3*12
		assertFalse( "attacker win when def < atk, " +
				"modified by die roll", ea.attack(atk1, def1));
	}
}
