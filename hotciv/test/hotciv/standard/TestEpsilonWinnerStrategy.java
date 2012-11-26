package hotciv.standard;

import hotciv.factories.*;
import hotciv.common.GameImpl;
import hotciv.framework.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestEpsilonWinnerStrategy {

    Game g = new GameImpl(new EpsilonFactory(), new TestEpsilonWorldGeneration());
    @Test
    public void shouldBeAWinnerAfter3SuccessfulAttacks(){
        g = new GameImpl(new EpsilonFactory(), new TestEpsilonWorldGeneration());
        assertNotNull("should be unit at position 2, 3", g.getUnitAt(new Position(2, 3)));
        g.moveUnit(new Position(2, 3), new Position(2, 4));
        g.moveUnit(new Position(6, 5), new Position(5, 5));
        assertNull("no winner should be found yet", g.getWinner());
        g.moveUnit(new Position(11,14), new Position(12, 13));
        assertEquals("red should be winner now", Player.RED, g.getWinner());
    }
}
