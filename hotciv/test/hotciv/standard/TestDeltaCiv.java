package hotciv.standard;

import hotciv.framework.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDeltaCiv {
	DeltaWorldGeneration wg;
	@Before
	public void setup() {
		wg = new DeltaWorldGeneration();
	}
	@Test
	public void ShouldGiveCorrectWorldTiles() {
		Tile[][] tiles = wg.generateTiles();
		assertEquals("There is a mountain at (0,5)", GameConstants.MOUNTAINS, 
				tiles[0][5].getTypeString());
		assertEquals("There is plains at (1,6)", GameConstants.PLAINS,
				tiles[1][6].getTypeString());
		assertEquals("There should be ocean at (0,0)", GameConstants.OCEANS,
				tiles[0][0].getTypeString());
		assertEquals("There should be oceans at (6,15)", GameConstants.OCEANS,
				tiles[6][15].getTypeString());
		assertEquals("There should be hills at (1,4)", GameConstants.HILLS,
				tiles[1][4].getTypeString());
		assertEquals("There should be forest at (9,3)", GameConstants.FOREST,
				tiles[9][3].getTypeString());
	}
	
	@Test
	public void ShouldGiveCorrectCities() {
		City[][] cities = wg.generateCities();
		assertNull("No cities at (1,1)", cities[1][1]);
		City c = cities[8][12];
		assertNotNull("City at (8,12)",c);
		assertEquals("Should have red owner", Player.RED, c.getOwner());
		c = cities[4][5];
		assertNotNull("City at (4,5)", c);
		assertEquals("Should have blue owner", Player.BLUE, c.getOwner());
	}
}
