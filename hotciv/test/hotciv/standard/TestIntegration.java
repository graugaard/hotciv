package hotciv.standard;

import hotciv.framework.*;
import org.junit.*;
import static org.junit.Assert.*;
public class TestIntegration {
	@Test
	public void BetaCivIntegration() {
		GameImpl g = new GameImpl(new BetaFactory());
		assertEquals("should start at age -4000", -4000, g.getAge());
		// perform 2*39 end of turn, to advance the age
		// which advanced with 39*100 years
		for (int i = 0; i < 2*39; i++) {
			g.endOfTurn();
		}
		assertEquals("age is -100", -100, g.getAge());
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("age is -1", -1, g.getAge());
		assertNull("no winners", g.getWinner());
	}
}