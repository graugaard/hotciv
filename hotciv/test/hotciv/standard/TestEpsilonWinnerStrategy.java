package hotciv.standard;

import hotciv.factories.*;
import hotciv.common.GameImpl;
import hotciv.framework.*;
import hotciv.strategy.EpsilonWinnerStrategy;
import hotciv.strategy.WinnerStrategy;

import org.junit.*;
import static org.junit.Assert.*;

public class TestEpsilonWinnerStrategy {

    ExtendedGame g = new GameImpl(new AlphaFactory(), new TestEpsilonWorldGeneration());
    WinnerStrategy ws = new EpsilonWinnerStrategy();
    @Test
    public void shouldBeAWinnerAfter3SuccessfulAttacks(){
        assertNotNull("should be unit at position 2, 3", g.getUnitAt(new Position(2, 3)));
        g.moveUnit(new Position(2, 3), new Position(2, 4));
        g.moveUnit(new Position(6, 5), new Position(5, 5));
        assertNull("no winner should be found yet", ws.getWinner(g, 0));
        g.moveUnit(new Position(11,14), new Position(12, 13));
        assertEquals("red should be winner now", Player.RED, ws.getWinner(g, 0));
    }
}
