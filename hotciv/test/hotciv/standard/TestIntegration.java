package hotciv.standard;

import hotciv.framework.*;
import org.junit.*;
import static org.junit.Assert.*;
public class TestIntegration {
	@Test
	public void BetaCivIntegration() {
		GameImpl g = new GameImpl(new BetaFactory(), new AlphaWorldGeneration());
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
    @Test
    public void GammaCivIntegration() {
        GameImpl g = new GameImpl(new GammaFactory(), new AlphaWorldGeneration());
        Unit u = g.getUnitAt(new Position(4, 3));
        assertEquals("settler at position 4, 3", GameConstants.SETTLER, u.getTypeString());
        assertNull("no city at position 4, 3", g.getCityAt(new Position(4, 3)));
        g.performUnitActionAt(new Position(4, 3));
        assertNotNull("city at position 4, 3", g.getCityAt(new Position(4, 3)));
        Unit arch = g.getUnitAt(new Position(2, 0));
        assertEquals("archer has 3 defense", 3, arch.getDefensiveStrength() );
        g.performUnitActionAt(new Position(2, 0));
        assertEquals("archer now has 6 defense", 6, arch.getDefensiveStrength());
        g.endOfTurn();
        g.endOfTurn();
        g.endOfTurn();
        g.endOfTurn();
        assertEquals("archer should have 0 move at start of turn",0 , arch.getMoveCount());
        g.performUnitActionAt(new Position(2, 0));
        g.endOfTurn();
        g.endOfTurn();
        assertEquals("archer should now have 1 movecount", 1, arch.getMoveCount());

    }
}