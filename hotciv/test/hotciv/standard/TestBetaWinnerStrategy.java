package hotciv.standard;

import hotciv.framework.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBetaWinnerStrategy {
    private Game g;
    @Before
    public void setUp() {
        g = new GameImpl(new BetaFactory());
    }

    @Test
    public void shouldNotBeAnyWinnerAtStart(){
        assertNull("", g.getWinner());
    }


}
