package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

/** Skeleton class for AlphaCiv test cases

   This source code is from the book                      1
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
*/
public class TestAlphaCiv {
  private Game game;
  /** Fixture for alphaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl();
  }

  @Test
  public void shouldHaveRedCityAt1_1() {
    City c = game.getCityAt(new Position(1,1));
    assertNotNull("There should be a city at (1,1)", c);
    Player p = c.getOwner();
    assertEquals( "City at (1,1) should be owned by red",
      Player.RED, p );
  }

  @Test
  public void shouldHaveBlueCityAt4_1() {
      City c = game.getCityAt(new Position(4,1));
      assertNotNull("There should be a city at (4,1)", c);
      Player p = c.getOwner();
      assertEquals( "City at (4,1) should be owned by blue",
              Player.BLUE, p );
  }

    @Test
    public void ShouldHaveTileOceanAt1_0() {
        Tile t = game.getTileAt(new Position(1,0));
        assertNotNull("Tile should be not null", t);
        assertEquals("Tile should be ocean",
                GameConstants.OCEANS,t.getTypeString());
    }
    @Test
    public void ShouldHaveHillTileAt0_1() {
        Tile t = game.getTileAt(new Position(0,1));
        assertNotNull("Tile should be not null", t);
        assertEquals("Tile is hills",
                GameConstants.HILLS,t.getTypeString());
    }
    @Test
    public void ShouldHaveMountainAt2_2() {
        Tile t = game.getTileAt(new Position(2,2));
        assertNotNull("Tile should exsist at (2,2)", t);
        assertEquals("Tile should be mountain at (2,2)",
                GameConstants.MOUNTAINS,t.getTypeString());
    }
    @Test
    public void ShouldBePlainsAt4_5And5_6() {
        Tile t = game.getTileAt(new Position(4,5));
        assertNotNull("Tile should exsist at (4,5)", t);
        assertEquals("Tile should be plains at (4,5)",
                GameConstants.PLAINS,t.getTypeString());
        t = game.getTileAt(new Position(5,6));
        assertNotNull("Tile should exsist at (5,6)", t);
        assertEquals("Tile should be plains at (5,6)",
                GameConstants.PLAINS,t.getTypeString());
    }
}