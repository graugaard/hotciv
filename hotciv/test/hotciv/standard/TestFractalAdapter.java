package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Tile;

import org.junit.*;
import static org.junit.Assert.*;

public class TestFractalAdapter {
	FractalAdapter fa;
	
	@Before
	public void setup() {
		fa = new FractalAdapter();
	}
	
	@Test
	public void ShouldGiveMountainTileWhenUsingChar_M() {

		Tile t = fa.charToTile('M');
		assertNotNull(t);
		assertEquals("Tile is mountain", GameConstants.MOUNTAINS, t.getTypeString());
	}
	
	@Test
	public void ShouldGiveOceanTileWhenUsingChar_Dot() {
		Tile t = fa.charToTile('.');
		assertNotNull(t);
		assertEquals("Tile is ocean", GameConstants.OCEANS, t.getTypeString());
	}
	
	@Test
	public void ShouldGiveForestTileWhenUsingChar_f() {
		Tile t = fa.charToTile('f');
		assertNotNull(t);
		assertEquals("Tile is forest", GameConstants.FOREST, t.getTypeString());
	}
	
	@Test
	public void ShouldGiveHillsTileWhenUsingChar_h() {
		Tile t = fa.charToTile('h');
		assertNotNull(t);
		assertEquals("Tile is hills", GameConstants.HILLS, t.getTypeString());
	}
	
	@Test
	public void ShouldGivePlainsTileWhenUsingChar_o() {
		Tile t = fa.charToTile('o');
		assertNotNull(t);
		assertEquals("Tile is plains", GameConstants.PLAINS, t.getTypeString());
	}
}
