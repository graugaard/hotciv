package hotciv.standard;

import hotciv.common.GameImpl;
import hotciv.framework.*;
import hotciv.factories.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestZetaCiv {

    GameImpl gam = new GameImpl(new ZetaFactory(), new TestEpsilonWorldGeneration());

    @Test
    public void shouldBeAWinnerAfterConqueringAllCities(){
        assertNull("should not be a winner yet", gam.getWinner());
        assertEquals("city at 1, 4 is blue", Player.BLUE, gam.getCityAt(new Position(1, 4)).getOwner());
        gam.moveUnit(new Position(2, 3), new Position(1, 4));
        assertEquals("city should now be red", Player.RED,  gam.getCityAt(new Position(1, 4)).getOwner());
        assertEquals("should be round 1", 1, gam.getCurrentRound());
        assertEquals("red should now be a winner", Player.RED, gam.getWinner());
    }


    Game g = new GameImpl(new ZetaFactory(), new TestEpsilonWorldGeneration());

    @Test
    public void shouldNotBeAWinnerBeforeRound20(){
        assertNull("should not give a winner at round 1", g.getWinner());
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        endRound();
        g.moveUnit(new Position(2, 3), new Position(2, 4));
        g.moveUnit(new Position(6, 5), new Position(5, 5));
        g.moveUnit(new Position(11,14), new Position(12, 13));
        assertNull("still should not be able to be a winner in round 19", g.getWinner());
        endRound();
    }

    GameImpl ga = new GameImpl(new ZetaFactory(), new TestEpsilonWorldGeneration());

    @Test
    public void shouldBeAWinnerAfter3AttacksAfterRound20(){
        assertNull("should not give a winner at round 1", ga.getWinner());
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        endRoundga();
        assertNull("still should not be able to be a winner in round 20", ga.getWinner());
        endRoundga();
        assertEquals("should now be round 21", 21 , ga.getCurrentRound());
        ga.moveUnit(new Position(2, 3), new Position(2, 4));
        ga.moveUnit(new Position(6, 5), new Position(5, 5));
        ga.moveUnit(new Position(11,14), new Position(12, 13));
        assertEquals("now we should have a winner", Player.RED, ga.getWinner());
    }


    public void endRound(){
        g.endOfTurn();
        g.endOfTurn();
    }
    public void endRoundga(){
        ga.endOfTurn();
        ga.endOfTurn();

    }

}
