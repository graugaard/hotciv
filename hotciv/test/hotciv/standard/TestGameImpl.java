package hotciv.standard;

import hotciv.framework.Position;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGameImpl {
	private GameImpl g;
	private List<Position> positions;
	
	@Before
	public void setUp() {
		
		g = new GameImpl();
		positions = null;
	}
	/* This is a major list of test designed to test the getPositions function of GameImpl class.
	 */
	@Test
	public void ShouldGetAllPositionsInDist1From8_9ClockwiseStartingAt7_9() {
		Position p = new Position(8,9);
		positions = g.getPositions(p,1);
		assertEquals("There are 8 positions in the list, " +
				"since there are 8 positions with distance 1",
				8, positions.size());
		assertEquals("(7,9) has same x as index 0 in the list",
				new Position(7,9), positions.get(0));
		assertEquals("(7,10) is at index 1 on the list",
				new Position(7,10), positions.get(1));
		assertEquals("(9,10) is at index 3",
				new Position(9,10), positions.get(3));
		
	}
	@Test
	public void ShouldGet6_7WhenAskingForAllPositionsWithDistance0From6_7() {
		Position p = new Position(6,7);
		positions = g.getPositions(p,0);
		assertEquals("Only 1 position in list", 1, positions.size());
		assertEquals("(6,7) is in the list", p, positions.get(0));
	}
	
	@Test
	public void ShouldGetAllPositionsInDistance3From7_7InOrder() {
		positions = g.getPositions(new Position(7,7),3);
		assertEquals("There are 24 positions in the list", 24, positions.size());
		assertEquals("(4,7) is at index 0",
				new Position(4,7), positions.get(0));
		assertEquals("(4,9) is at index 2",
				new Position(4,9), positions.get(2));
		assertEquals("(4,10) is at index 3",
				new Position(4,10), positions.get(3));
		assertEquals("(7,10) is at index 6",
				new Position(7,10), positions.get(6));
		assertEquals("(10,10) is at index 9",
				new Position(10,10), positions.get(9));
		assertEquals("(10,8) is at index 11",
				new Position(10,8), positions.get(11));
		assertEquals("(10,4) is at index 15",
				new Position(10,4), positions.get(15));
		assertEquals("(6,4) is at index 19",
				new Position(6,4), positions.get(19));
		assertEquals("(4,4) is at index 21",
				new Position(4,4), positions.get(21));
		assertEquals("(4,6) is at index 23",
				new Position(4,6), positions.get(23));
	}
	
	@Test
	public void ShouldOnlyGetValidPositions() {
		
	}

}
