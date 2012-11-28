package hotciv.standard;

import hotciv.common.*;
import hotciv.factories.BetaFactory;
import hotciv.framework.*;
import hotciv.standard.utilities.TestBetaWorldGeneration;
import hotciv.strategy.BetaWinnerStrategy;
import hotciv.strategy.WinnerStrategy;


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
        assertNull("No winner should be found", betaWin.getWinner(g, 1));
    }
    @Test
    public void ShoulBePlayerRedWins() {
    	g = new GameImpl(new BetaFactory(), new TestBetaWorldGeneration());
    	assertEquals("Red owns the cities", Player.RED, 
    			g.getCityAt(new Position(1,1)).getOwner());
    	assertEquals("Red owns cities", Player.RED,
    			g.getCityAt(new Position(4,1)).getOwner());
    	assertEquals("Red Wins", Player.RED, betaWin.getWinner(g, 1));
    }


}
