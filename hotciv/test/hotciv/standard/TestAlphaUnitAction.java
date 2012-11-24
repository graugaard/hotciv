package hotciv.standard;

import hotciv.factories.AlphaFactory;
import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestAlphaUnitAction {
    private Game game;
    @Before
    public void setUp() {
        game = new GameImpl(new AlphaFactory(), new AlphaWorldGeneration());
    }
    @Test
    public void shouldNotGiveNullPointerException() {
        game.performUnitActionAt(new Position(0, 0));
    }

    @Test
    public void shouldNotBuildAnyCityWithSettlerAction() {
        Unit u = game.getUnitAt(new Position(4, 3));
        assertEquals("should be a settler at position 4, 3", GameConstants.SETTLER, u.getTypeString());
        game.performUnitActionAt(new Position(4, 3));
        assertNull("should not be a city at 4, 3", game.getCityAt(new Position(4, 3)));

    }

    @Test
    public void shouldNotFortifyArcher() {
        Unit u = game.getUnitAt(new Position(2, 0));
        assertEquals("should be an archer at position 2, 0", GameConstants.ARCHER, u.getTypeString());
        assertEquals("archer should have defensive strength 3", 3, u.getDefensiveStrength());
        assertEquals("archer should have moveCount 1", 1, u.getMoveCount());
        game.performUnitActionAt(new Position(2, 0));
        assertEquals("archer should still have defensive strength 3", 3, u.getDefensiveStrength());
        assertEquals("archer should still have moveCount 1", 1, u.getMoveCount());
    }


}
