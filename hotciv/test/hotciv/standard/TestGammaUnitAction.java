package hotciv.standard;

import hotciv.common.GameImpl;
import hotciv.factories.GammaFactory;
import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGammaUnitAction {

        private Game game;
        @Before
        public void setUp() {
            game = new GameImpl(new GammaFactory(), new AlphaWorldGeneration());
        }
        @Test
        public void shouldNotGiveNullPointerException() {
            game.performUnitActionAt(new Position(0, 0));
        }

        @Test
        public void shouldBuildACityWithSettlerAction() {
            Unit u = game.getUnitAt(new Position(4, 3));
            Player uOwner = u.getOwner();
            assertEquals("should be a settler at position 4, 3", GameConstants.SETTLER, u.getTypeString());
            game.performUnitActionAt(new Position(4, 3));
            Player cOwner = game.getCityAt(new Position(4, 3)).getOwner();
            assertNull("should not be a unit at position 4, 3", game.getUnitAt(new Position(4, 3)));
            assertNotNull("should be a city at 4, 3", game.getCityAt(new Position(4, 3)));
            assertEquals("owner should be same as settlerowner", uOwner, cOwner);

        }

        @Test
        public void shouldNotFortifyArcher() {
            Unit u = game.getUnitAt(new Position(2, 0));
            assertEquals("should be an archer at position 2, 0", GameConstants.ARCHER, u.getTypeString());
            assertEquals("archer should have defensive strength 3", 3, u.getDefensiveStrength());
            assertEquals("archer should have moveCount 1", 1, u.getMoveCount());
            game.performUnitActionAt(new Position(2, 0));
            assertEquals("archer should now have defensive strength 6", 6, u.getDefensiveStrength());
            assertEquals("archer should now have moveCount 0", 0, u.getMoveCount());
        }



    }
