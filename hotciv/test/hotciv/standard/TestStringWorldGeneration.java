package hotciv.standard;

import hotciv.framework.*;
import hotciv.standard.utilities.StringWorldGeneration;

import org.junit.*;
import static org.junit.Assert.*;

public class TestStringWorldGeneration {
	StringWorldGeneration wg;
	
	@Before
	public void setUp() {
		String[] t = { "." };
		String[] c = { "." };
		String[] u = { "." };
		wg = new StringWorldGeneration(t, c, u);
	}
	@Test
	public void ShouldGiveCorrectHeightAndWidthFor2By2World() {
		String[] worldTiles = { "..", ".." };
		String[] worldCities = { "..", ".." };
		String[] worldUnits = { "..", ".." };
		wg = new StringWorldGeneration( worldTiles, worldCities, 
						worldUnits );
		assertEquals("Height is 2", 2, wg.getWorldHeight());
		assertEquals("Width is 2", 2, wg.getWorldWidth());
	}
	
	@Test
	public void ShouldGiveCorrectHeightAndWidthFor5By6World() {
		String[] worldTiles = { "..OfhM", "..OOhh", "ffhhMM",
				"...Off", "MMMfff" };
		String[] worldCities = { "R..B..", "......", "...B..",
				"......", "......"};
		String[] worldUnits = { "aa.s.l", "AA..lS", "......",
				"......", "......" };
		wg = new StringWorldGeneration(worldTiles, worldCities,
						worldUnits);
		assertEquals("Height is 5", 5, wg.getWorldHeight());
		assertEquals("Width is 6", 6, wg.getWorldWidth());
		
		String[][] combined = { worldTiles, worldCities, worldUnits};
		wg = new StringWorldGeneration( combined );
		assertEquals("Height is 5", 5, wg.getWorldHeight());
		assertEquals("Width is 6", 6, wg.getWorldWidth());
	}
	
	@Test
	public void ShouldGenerateCorrectTiles1() {
		String[] worldTiles = { ".OMfh", "....." };
		String[] worldCities = { ".....", "....." };
		String[] worldUnits = { ".....", "......" };
		wg = new StringWorldGeneration( worldTiles,
				worldCities, worldUnits);
		Tile[][] tiles = wg.generateTiles();
		assertEquals("(0,0) is plains", GameConstants.PLAINS,
				tiles[0][0].getTypeString());
		assertEquals("(0,1) is ocean", GameConstants.OCEANS,
				tiles[0][1].getTypeString());
		assertEquals("(0,2) is mountains", GameConstants.MOUNTAINS,
				tiles[0][2].getTypeString());
		assertEquals("(0,3) is forest", GameConstants.FOREST,
				tiles[0][3].getTypeString());
		assertEquals("(0,4) is hills", GameConstants.HILLS,
				tiles[0][4].getTypeString());
		assertEquals("(1,3) is plains", GameConstants.PLAINS,
				tiles[1][3].getTypeString());
	}
	
	@Test
	public void ShouldGenerateCorrectTiles2() {
		String[] worldTiles = { ".OMfh", "....." };
		String[] worldCities = { ".....", "....." };
		String[] worldUnits = { ".....", "......" };
		String[][] combined = { worldTiles, worldCities,
				worldUnits };
		wg = new StringWorldGeneration( combined );
		Tile[][] tiles = wg.generateTiles();
		assertEquals("(0,0) is plains", GameConstants.PLAINS,
				tiles[0][0].getTypeString());
		assertEquals("(0,1) is ocean", GameConstants.OCEANS,
				tiles[0][1].getTypeString());
		assertEquals("(0,2) is mountains", GameConstants.MOUNTAINS,
				tiles[0][2].getTypeString());
		assertEquals("(0,3) is forest", GameConstants.FOREST,
				tiles[0][3].getTypeString());
		assertEquals("(0,4) is hills", GameConstants.HILLS,
				tiles[0][4].getTypeString());
		assertEquals("(1,3) is plains", GameConstants.PLAINS,
				tiles[1][3].getTypeString());
	}
	
	@Test
	public void ShouldGenerateCorrectCities1() {
		String[] worldTiles = { "...", "...", "..." };
		String[] worldCities = { "..R", "RB.", "..." };
		String[] worldUnits = { "...", "...", "..." };
		wg = new StringWorldGeneration( worldTiles,
				worldCities, worldUnits);
		City[][] cities = wg.generateCities();
		assertNull("No city at (0,0)", cities[0][0]);
		assertNotNull("City at (0,2)", cities[0][2]);
		assertEquals("Red city at (0,2)", Player.RED,
				cities[0][2].getOwner());
		
		assertNotNull("City at (1,0)", cities[1][0]);
		assertEquals("Red city at (1,0)", Player.RED,
				cities[1][0].getOwner());
		
		assertNotNull("City at (1,1)", cities[1][1]);
		assertEquals("Blue city at(1,1)", Player.BLUE,
				cities[1][1].getOwner());
		assertNull("No city at (2,1)", cities[2][1]);
		assertNull("No city at (2,2)", cities[2][2]);
	}
	
	@Test
	public void ShouldGenerateCorrectCities2() {
		String[] worldTiles = { "...", "...", "..." };
		String[] worldCities = { "..R", "RB.", "..." };
		String[] worldUnits = { "...", "...", "..." };
		String[][] combined = { worldTiles, worldCities,
				worldUnits};
		wg = new StringWorldGeneration( combined );
		City[][] cities = wg.generateCities();
		assertNull("No city at (0,0)", cities[0][0]);
		assertNotNull("City at (0,2)", cities[0][2]);
		assertEquals("Red city at (0,2)", Player.RED,
				cities[0][2].getOwner());
		
		assertNotNull("City at (1,0)", cities[1][0]);
		assertEquals("Red city at (1,0)", Player.RED,
				cities[1][0].getOwner());
		
		assertNotNull("City at (1,1)", cities[1][1]);
		assertEquals("Blue city at(1,1)", Player.BLUE,
				cities[1][1].getOwner());
		assertNull("No city at (2,1)", cities[2][1]);
		assertNull("No city at (2,2)", cities[2][2]);
	}
	
	@Test
	public void ShouldGenerateCorrectRedUnits1() {
		String[] tiles = { "....", "hhMO", "" };
		String[] cities = { "R...", "....", "...B" };
		String[] worldUnits = { ".A.l", "S.a.", ".L.s" };
		wg = new StringWorldGeneration( tiles, cities, worldUnits );
		Unit[][] units = wg.generateUnits();
		assertNull( "No units at (0,0)", units[0][0] );
		assertNull( "No units at (1,3)", units[1][3] );
		
		assertNotNull( "Unit at (0,1)", units[0][1] );
		assertEquals( "Red unit at (0,1)", Player.RED, 
				units[0][1].getOwner() );
		assertEquals( "Archer at (0,1)", GameConstants.ARCHER, 
				units[0][1].getTypeString() );
		
		assertNotNull( "Unit at (1,0)", units[1][0] );
		assertEquals( "Red unit at (1,0)", Player.RED, 
				units[1][0].getOwner() );
		assertEquals( "Settler at (1,0)", GameConstants.SETTLER, 
				units[1][0].getTypeString() );
		
		assertNotNull( "Unit at (2,1)", units[2][1] );
		assertEquals( "Red unit at (2,1)", Player.RED, 
				units[2][1].getOwner() );
		assertEquals( "Legion at (2,1)", GameConstants.LEGION, 
				units[2][1].getTypeString() );
	}
	
	@Test
	public void ShouldGenerateCorrectBlueUnits1() {
		String[] tiles = { "....", "hhMO", "" };
		String[] cities = { "R...", "....", "...B" };
		String[] worldUnits = { ".A.l", "S.a.", ".L.s" };
		wg = new StringWorldGeneration( tiles, cities, worldUnits );
		Unit[][] units = wg.generateUnits();
		assertNull( "No units at (0,0)", units[0][0] );
		assertNull( "No units at (1,3)", units[1][3] );

		assertNotNull( "Unit at (0,3)", units[0][3] );
		assertEquals( "Blue unit at (0,3)", Player.BLUE, 
				units[0][3].getOwner() );
		assertEquals( "Legion at (3,0)", GameConstants.LEGION, 
				units[0][3].getTypeString() );

		assertNotNull( "Unit at (1,2)", units[1][2] );
		assertEquals( "Blue unit at (1,2)", Player.BLUE, 
				units[1][2].getOwner() );
		assertEquals( "Archer at (1,2)", GameConstants.ARCHER, 
				units[1][2].getTypeString() );
		
		assertNotNull( "Unit at (2,3)", units[2][3] );
		assertEquals( "Blue unit at (2,3)", Player.BLUE, 
				units[2][3].getOwner() );
		assertEquals( "Settler at (2,3)", GameConstants.SETTLER, 
				units[2][3].getTypeString() );
	}
	
	@Test
	public void ShouldGenerateCorrectRedUnits2() {
		String[] tiles = { "....", "hhMO", "" };
		String[] cities = { "R...", "....", "...B" };
		String[] worldUnits = { ".A.l", "S.a.", ".L.s" };
		String[][] combined = { tiles, cities, worldUnits };
		wg = new StringWorldGeneration( combined );
		Unit[][] units = wg.generateUnits();
		assertNull( "No units at (0,0)", units[0][0] );
		assertNull( "No units at (1,3)", units[1][3] );
		
		assertNotNull( "Unit at (0,1)", units[0][1] );
		assertEquals( "Red unit at (0,1)", Player.RED, 
				units[0][1].getOwner() );
		assertEquals( "Archer at (0,1)", GameConstants.ARCHER, 
				units[0][1].getTypeString() );
		
		assertNotNull( "Unit at (1,0)", units[1][0] );
		assertEquals( "Red unit at (1,0)", Player.RED, 
				units[1][0].getOwner() );
		assertEquals( "Settler at (1,0)", GameConstants.SETTLER, 
				units[1][0].getTypeString() );
		
		assertNotNull( "Unit at (2,1)", units[2][1] );
		assertEquals( "Red unit at (2,1)", Player.RED, 
				units[2][1].getOwner() );
		assertEquals( "Legion at (2,1)", GameConstants.LEGION, 
				units[2][1].getTypeString() );
	}
	
	@Test
	public void ShouldGenerateCorrectBlueUnits2() {
		String[] tiles = { "....", "hhMO", "" };
		String[] cities = { "R...", "....", "...B" };
		String[] worldUnits = { ".A.l", "S.a.", ".L.s" };
		String[][] combined = { tiles, cities, worldUnits };
		wg = new StringWorldGeneration( combined );
		Unit[][] units = wg.generateUnits();
		assertNull( "No units at (0,0)", units[0][0] );
		assertNull( "No units at (1,3)", units[1][3] );

		assertNotNull( "Unit at (0,3)", units[0][3] );
		assertEquals( "Blue unit at (0,3)", Player.BLUE, 
				units[0][3].getOwner() );
		assertEquals( "Legion at (3,0)", GameConstants.LEGION, 
				units[0][3].getTypeString() );

		assertNotNull( "Unit at (1,2)", units[1][2] );
		assertEquals( "Blue unit at (1,2)", Player.BLUE, 
				units[1][2].getOwner() );
		assertEquals( "Archer at (1,2)", GameConstants.ARCHER, 
				units[1][2].getTypeString() );
		
		assertNotNull( "Unit at (2,3)", units[2][3] );
		assertEquals( "Blue unit at (2,3)", Player.BLUE, 
				units[2][3].getOwner() );
		assertEquals( "Settler at (2,3)", GameConstants.SETTLER, 
				units[2][3].getTypeString() );
	}
}
