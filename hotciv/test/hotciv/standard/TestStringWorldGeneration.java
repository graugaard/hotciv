package hotciv.standard;

import hotciv.standard.utilities.StringWorldGeneration;

import org.junit.*;
import static org.junit.Assert.*;

public class TestStringWorldGeneration {

	@Test
	public void ShouldGiveCorrectHeightAndWidth() {
		String[] worldTiles = { ".O", "fh" };
		String[] worldCities = { "..", ".." };
		String[] worldUnits = { "..", ".." };
		StringWorldGeneration wg = 
				new StringWorldGeneration( worldTiles, worldCities, 
						worldUnits );
		assertEquals("Height is 2", 2, wg.getWorldHeight());
		assertEquals("Width is 2", 2, wg.getWorldWidth());
	}
}
