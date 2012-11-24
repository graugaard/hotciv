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
		assertEquals("(1,0) is ocean", GameConstants.OCEANS,
				tiles[1][0].getTypeString());
		assertEquals("(2,0) is mountains", GameConstants.MOUNTAINS,
				tiles[2][0].getTypeString());
		assertEquals("(3,0) is forest", GameConstants.FOREST,
				tiles[3][0].getTypeString());
		assertEquals("(4,0) is hills", GameConstants.HILLS,
				tiles[4][0].getTypeString());
		assertEquals("(1,3) is plains", GameConstants.PLAINS,
				tiles[3][1].getTypeString());
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
		assertEquals("(1,0) is ocean", GameConstants.OCEANS,
				tiles[1][0].getTypeString());
		assertEquals("(2,0) is mountains", GameConstants.MOUNTAINS,
				tiles[2][0].getTypeString());
		assertEquals("(3,0) is forest", GameConstants.FOREST,
				tiles[3][0].getTypeString());
		assertEquals("(4,0) is hills", GameConstants.HILLS,
				tiles[4][0].getTypeString());
		assertEquals("(1,3) is plains", GameConstants.PLAINS,
				tiles[3][1].getTypeString());
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
		assertNotNull("City at (2,0)", cities[2][0]);
		assertEquals("Red city at(2,0)", Player.RED,
				cities[2][0].getOwner());
		
		assertNotNull("City at (0,1)", cities[0][1]);
		assertEquals("Red city at(0,1)", Player.RED,
				cities[0][1].getOwner());
		
		assertNotNull("City at (1,1)", cities[1][1]);
		assertEquals("Blue city at(1,1)", Player.BLUE,
				cities[1][1].getOwner());
		assertNull("No city at (1,2)", cities[1][2]);
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
		assertNotNull("City at (2,0)", cities[2][0]);
		assertEquals("Red city at(2,0)", Player.RED,
				cities[2][0].getOwner());
		
		assertNotNull("City at (0,1)", cities[0][1]);
		assertEquals("Red city at(0,1)", Player.RED,
				cities[0][1].getOwner());
		
		assertNotNull("City at (1,1)", cities[1][1]);
		assertEquals("Blue city at(1,1)", Player.BLUE,
				cities[1][1].getOwner());
		assertNull("No city at (1,2)", cities[1][2]);
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
		assertNull( "No units at (3,1)", units[3][1] );
		
		assertNotNull( "Unit at (1,0)", units[1][0] );
		assertEquals( "Red unit at (1,0)", Player.RED, 
				units[1][0].getOwner() );
		assertEquals( "Archer at (1,0)", GameConstants.ARCHER, 
				units[1][0].getTypeString() );
		
		assertNotNull( "Unit at (0,1)", units[0][1] );
		assertEquals( "Red unit at (0,1)", Player.RED, 
				units[0][1].getOwner() );
		assertEquals( "Settler at (0,1)", GameConstants.SETTLER, 
				units[0][1].getTypeString() );
		
		assertNotNull( "Unit at (1,2)", units[1][2] );
		assertEquals( "Red unit at (1,2)", Player.RED, 
				units[1][2].getOwner() );
		assertEquals( "Legion at (1,2)", GameConstants.LEGION, 
				units[1][2].getTypeString() );
	}
	
	@Test
	public void ShouldGenerateCorrectBlueUnits1() {
		String[] tiles = { "....", "hhMO", "" };
		String[] cities = { "R...", "....", "...B" };
		String[] worldUnits = { ".A.l", "S.a.", ".L.s" };
		wg = new StringWorldGeneration( tiles, cities, worldUnits );
		Unit[][] units = wg.generateUnits();
		assertNull( "No units at (0,0)", units[0][0] );
		assertNull( "No units at (3,1)", units[3][1] );

		assertNotNull( "Unit at (3,0)", units[3][0] );
		assertEquals( "Blue unit at (3,0)", Player.BLUE, 
				units[3][0].getOwner() );
		assertEquals( "Legion at (3,0)", GameConstants.LEGION, 
				units[3][0].getTypeString() );

		assertNotNull( "Unit at (2,1)", units[2][1] );
		assertEquals( "Blue unit at (2,1)", Player.BLUE, 
				units[2][1].getOwner() );
		assertEquals( "Archer at (2,1)", GameConstants.ARCHER, 
				units[2][1].getTypeString() );
		
		assertNotNull( "Unit at (3,2)", units[3][2] );
		assertEquals( "Blue unit at (3,2)", Player.BLUE, 
				units[3][2].getOwner() );
		assertEquals( "Settler at (3,2)", GameConstants.SETTLER, 
				units[3][2].getTypeString() );
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
		assertNull( "No units at (3,1)", units[3][1] );
		
		assertNotNull( "Unit at (1,0)", units[1][0] );
		assertEquals( "Red unit at (1,0)", Player.RED, 
				units[1][0].getOwner() );
		assertEquals( "Archer at (1,0)", GameConstants.ARCHER, 
				units[1][0].getTypeString() );
		
		assertNotNull( "Unit at (0,1)", units[0][1] );
		assertEquals( "Red unit at (0,1)", Player.RED, 
				units[0][1].getOwner() );
		assertEquals( "Settler at (0,1)", GameConstants.SETTLER, 
				units[0][1].getTypeString() );
		
		assertNotNull( "Unit at (1,2)", units[1][2] );
		assertEquals( "Red unit at (1,2)", Player.RED, 
				units[1][2].getOwner() );
		assertEquals( "Legion at (1,2)", GameConstants.LEGION, 
				units[1][2].getTypeString() );
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
		assertNull( "No units at (3,1)", units[3][1] );

		assertNotNull( "Unit at (3,0)", units[3][0] );
		assertEquals( "Blue unit at (3,0)", Player.BLUE, 
				units[3][0].getOwner() );
		assertEquals( "Legion at (3,0)", GameConstants.LEGION, 
				units[3][0].getTypeString() );

		assertNotNull( "Unit at (2,1)", units[2][1] );
		assertEquals( "Blue unit at (2,1)", Player.BLUE, 
				units[2][1].getOwner() );
		assertEquals( "Archer at (2,1)", GameConstants.ARCHER, 
				units[2][1].getTypeString() );
		
		assertNotNull( "Unit at (3,2)", units[3][2] );
		assertEquals( "Blue unit at (3,2)", Player.BLUE, 
				units[3][2].getOwner() );
		assertEquals( "Settler at (3,2)", GameConstants.SETTLER, 
				units[3][2].getTypeString() );
	}
}
