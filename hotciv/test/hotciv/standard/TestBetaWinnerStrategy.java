package hotciv.standard;

import hotciv.framework.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBetaWinnerStrategy {
    private Game g;
    private WinnerStrategy betaWin;
    @Before
    public void setUp() {
        g = new GameImpl(new BetaFactory(), new AlphaWorldGeneration());
        betaWin = new BetaWinnerStrategy();
    }

    @Test
    public void shouldNotBeAnyWinnerAtStart(){
        assertNull("No winner should be found", betaWin.getWinner(g));
    }
    @Test
    public void ShoulBePlayerRedWins() {
    	g = new TestBetaWinner();
    	assertEquals("Red owns the cities", Player.RED, 
    			g.getCityAt(new Position(1,1)).getOwner());
    	assertEquals("Red owns cities", Player.RED,
    			g.getCityAt(new Position(4,1)).getOwner());
    	assertEquals("Red Wins", Player.RED, betaWin.getWinner(g));
    }


}
