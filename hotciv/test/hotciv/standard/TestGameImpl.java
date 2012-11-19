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
		g = new GameImpl(new AlphaFactory());
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
		assertEquals("Only 1 position with dist 0 to (6,7)", 1, positions.size());
		assertEquals("(6,7) is in the list", p, positions.get(0));
	}
	
	/* === ARGUMENT FOR THE FOLLOWING TEST CASES ===
	 * It can be proven mathematically that there are 8*n points (x',y') around (x,y)
	 * with x,y integers, where max(|x-x'|,|y-y'|) = n, n>=1. To see this, realize
	 * this is the case for n = 1 and assume for an n. Now, consider the points of n+1. 
	 * Ignonring the cases where |x-x'|=|y-y'| = n+1, these points are either rigt above, below
	 * or to the sides of the prevoius points. The corners have 2 close to them
	 * (one above or below, and one to the side), the rest 1. This means we have 8n + 4, where 
	 * the 4 is the extra from the corners. Add 4 for the corners we ignonred and we get that
	 * 8n + 8 = 8(n+1), as claimed.
	 */
	@Test
	public void ShouldGetAllPositionsInDistance3From7_7InOrder() {
		positions = g.getPositions(new Position(7,7),3);
		
		assertEquals("There are 24 positions with dist 7 to (7,7)", 24, positions.size());
		
		// these are all positions in distance 3 from (7,7). 
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
	public void ShouldOnlyGetValidWorldPositions() {

		/* We check it also cuts y values in opposite side
		 * and where x < 0 and x > 16 and the same with y
		 */
		positions = g.getPositions(new Position(0,0),1);
		assertEquals("There are 3 points with dist 1 to (0,0)", 3, positions.size());
		assertEquals("(0,1) is at index 0", 
				new Position(0,1),positions.get(0));
		
		positions = g.getPositions(new Position(15,15),2);
		assertEquals("There are 5 points with dist 2 to (15,15)",
				5, positions.size());
		assertEquals("(13,15) is at index 0", 
				new Position(13,15), positions.get(0));
	}
	
	@Test
	public void ShouldNotGetAnyPositionsWhenDistanceIsNegative() {
		positions = g.getPositions(new Position(4,5), -5);
		assertEquals("No positions in negative distance", 0, positions.size());
	}

}
