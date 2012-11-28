package hotciv.standard;

import hotciv.common.GameImpl;
import hotciv.framework.*;
import hotciv.factories.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestZetaCiv {

    private ExtendedGame game;

    @Before
    public void setUp(){
    game = new GameImpl(new ZetaFactory(), new TestEpsilonWorldGeneration());
    }

    @Test
    public void shouldBeAWinnerAfterConqueringAllCities(){
        assertNull("should not be a winner yet", game.getWinner());
        assertEquals("city at 1, 4 is blue", Player.BLUE, game.getCityAt(new Position(1, 4)).getOwner());
        game.moveUnit(new Position(2, 3), new Position(1, 4));
        assertEquals("city should now be red", Player.RED,  game.getCityAt(new Position(1, 4)).getOwner());
        assertEquals("should be round 1", 1, game.getCurrentRound());
        assertEquals("red should now be a winner", Player.RED, game.getWinner());
    }
    @Test
    public void shouldNotBeAWinnerAfterConqueringAllCitiesAfterRound20(){

        for(int i=0; i<20; i++){
            endRound();
        }

        assertNull("should not be a winner yet", game.getWinner());
        assertEquals("city at 1, 4 is blue", Player.BLUE, game.getCityAt(new Position(1, 4)).getOwner());
        game.moveUnit(new Position(2, 3), new Position(1, 4));
        assertEquals("city should now be red", Player.RED,  game.getCityAt(new Position(1, 4)).getOwner());
        assertEquals("should be round 21", 21, game.getCurrentRound());
        assertNull("red should now be a winner",  game.getWinner());
    }


    @Test
    public void shouldNotBeAWinnerBeforeRound20(){
        assertNull("should not give a winner at round 1", game.getWinner());
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
        game.moveUnit(new Position(2, 3), new Position(2, 4));
        game.moveUnit(new Position(6, 5), new Position(5, 5));
        game.moveUnit(new Position(11,14), new Position(12, 13));
        assertNull("still should not be able to be a winner in round 19", game.getWinner());
        endRound();
        endRound();
        endRound();
        endRound();
        assertNull("still should not be able to find a winner " +
                "since no attacks was won after round 20", game.getWinner());
    }

    @Test
    public void shouldBeAWinnerAfter3AttacksAfterRound20(){
        assertNull("should not give a winner at round 1", game.getWinner());
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
        endRound();
        assertNull("still should not be able to be a winner in round 20", game.getWinner());
        endRound();
        assertEquals("should now be round 21", 21 , game.getCurrentRound());
        game.moveUnit(new Position(2, 3), new Position(2, 4));
        game.moveUnit(new Position(6, 5), new Position(5, 5));
        game.moveUnit(new Position(11,14), new Position(12, 13));
        assertEquals("now we should have a winner", Player.RED, game.getWinner());
    }


    public void endRound(){
        game.endOfTurn();
        game.endOfTurn();
    }
}
