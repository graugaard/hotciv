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
    Position redcity = new Position(1,1);
    Position bluecity = new Position(4,1);
    /** Fixture for alphaciv testing. */
    @Before
    public void setUp() {
        game = new GameImpl(new AlphaAgeStrategy(), new AlphaWinnerStrategy() {
        });

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
    // test if if a lot of different tiles are plains
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

    @Test
    public void ShouldHaveRedArcherAt2_0() {
        Unit u = game.getUnitAt(new Position(2,0));
        assertNotNull("Unit is at (2,0)", u);
        assertEquals("Unit at (2,0) is an archer",
                GameConstants.ARCHER, u.getTypeString());
        assertEquals("Unit at (2,0) belongs to player RED",
                Player.RED, u.getOwner());
    }

    @Test
    public void ShouldHaveRedSettlerAt4_3() {
        Unit u = game.getUnitAt(new Position(4, 3));
        assertNotNull("There is a unit at (4,3)", u);
        assertEquals("Unit at (4,3) is a settler",
                GameConstants.SETTLER, u.getTypeString());
        assertEquals("Unit at (4,3) belongs to red",
                Player.RED, u.getOwner());
    }

    @Test
    public void ShouldHaveBlueLegionAt3_2() {
        Unit u = game.getUnitAt(new Position(3,2));
        assertNotNull("There is a unit at (3,2)", u);
        assertEquals("Unit at (3,2) is a legion",
                GameConstants.LEGION,u.getTypeString());
        assertEquals("Unit at (3,2) belongs to blue",
                Player.BLUE,u.getOwner());
    }

    @Test
    public void shouldHaveDistance2From3_2To4_2() {
        Position p1 = new Position(2,3);
        Position p2 = new Position(4,2);
        assertEquals("distance (2,3) to (4,2) is 2",2,
                game.dist(p1, p2));
    }

    @Test
    public void ShouldHaveUnitMoveLimit1() {
        // we assume red starts the game
        // red archer should be able to move
        assertTrue("legal move", game.moveUnit(new Position(2, 0), new Position(1, 1)));
        // cant move 2 or more in one turn
        assertFalse("units can't move more than 1",game.moveUnit(new Position(4,3), new Position(6,5)));
        // move limit expended, has moved 2
        assertFalse("units can't move 1 after moving 1", game.moveUnit(new Position(1, 1), new Position(0, 1)));
    }

    @Test
    public void ShouldHaveMovedUnit() {
        //first move an unit
        game.moveUnit(new Position(2, 0), new Position(2, 1));
        //unit have moved from position
        assertNull("No unit at (2, 0)", game.getUnitAt(new Position(2, 0)));
        Unit u = game.getUnitAt(new Position(2, 1));
        //unit at new position
        assertNotNull("Unit at position (2, 1)", u);
        //unit is red
        assertEquals("Unit at (2, 1) is red",Player.RED, u.getOwner());
        //unit is an archer
        assertEquals("Unit at (2,1) is an archer", GameConstants.ARCHER, u.getTypeString());
    }

    @Test
    public void ShouldBeRedPlayerFirstThenBlueThenRed() {
        //first player should be red
        assertEquals("Player should be red first", Player.RED, game.getPlayerInTurn());
        game.endOfTurn();
        assertEquals("Player should be blue second", Player.BLUE, game.getPlayerInTurn());
        game.endOfTurn();
        assertEquals("Player should be red third", Player.RED, game.getPlayerInTurn());


    }

    @Test
    public void ShouldOnlyMoveSameColor() {
        //red moves blues unit
        assertFalse("Red should not move blue", game.moveUnit(new Position(3,2), new Position(4,2)));
        game.endOfTurn();
        assertTrue("Blue should move blue", game.moveUnit(new Position(3,2), new Position(4,2)));
    }

    @Test
    public void ShouldStartAt4000bcAndAdvance100YearsOnEndofRound() {
        //check if the starting age is right
        assertEquals("starting age should be -4000", -4000, game.getAge());
        game.endOfTurn();
        game.endOfTurn();
        //check if the age changes after both players have had their turn
        assertEquals("age should be -3900", -3900, game.getAge());
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        //check that the age is right when we change to blue player
        assertEquals("age should be -3800", -3800, game.getAge());

    }

    @Test
    public void ShouldRedWinAt3000BC(){
        //there should be no winner at game start
        assertNull("there should be no winner at the beginning",game.getWinner());
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        game.endOfTurn();
        //and still no winner just before the age changes to -3000
        assertNull("there should still be no winner", game.getWinner());
        game.endOfTurn();
        //test if the age is actually -3000
        assertEquals("test if the age is indeed -3000", -3000, game.getAge());
        //at age  -3000 the winner should be red
        assertEquals("the winner should be red", Player.RED, game.getWinner());
    }

    @Test
    public void ShouldBePopulationSize1InCities(){
        //test if population size is 1
        City c = game.getCityAt(new Position(4,1));
        assertEquals("population size should be 1", 1, c.getSize());
    }

    @Test
    public void ShouldProduceUnitsInCity() {
        Position p = new Position(4, 1);
        City c = game.getCityAt(p);
        assertEquals("city should produce settler with no choice", GameConstants.SETTLER, c.getProduction());
        game.changeProductionInCityAt(p, GameConstants.ARCHER);
        assertEquals("city should produce archer now", GameConstants.ARCHER, c.getProduction());
        game.changeProductionInCityAt(p, GameConstants.LEGION);
        assertEquals("city should now produce legion", GameConstants.LEGION, c.getProduction());


    }

    @Test
    public void ShouldBeAttackingUnitAlwaysWins() {
        //unit should be able to move to a spot with an enemy unit on it and take that position
        assertTrue("unit can't move to a slot with another unit", game.moveUnit(new Position(4, 3), new Position(3, 2)));
        //make sure the unit isn't at it's previous spot anymore
        assertNull("no unit in position (4, 3) anymore", game.getUnitAt(new Position(4, 3)));
    }

    @Test
    public void ShouldBeAbleToMoveAgainAtNewRound() {
        //move unit and let the round be over
        game.moveUnit(new Position(4, 3), new Position(3, 2));
        game.endOfTurn();
        game.endOfTurn();
        //the unit should be able to move again now
        assertTrue("unit should be able to move again", game.moveUnit(new Position(3, 2), new Position(3, 1)));
    }
    @Test
    public void ShouldNotBeAbleToMoveToSpaceWithOwnUnitOnIt(){
        game.moveUnit(new Position(4, 3), new Position(3, 2));
        game.moveUnit(new Position(2, 0), new Position(3, 1));
        game.endOfTurn();
        game.endOfTurn();
        assertFalse("should not be able to move unit to spot with own unit", game.moveUnit(new Position(3, 2), new Position(3, 1)));

    }

    @Test
    public void ShouldBeAddProductionWorksForCityImpl() {
        CityImpl c = new CityImpl(Player.RED);
        c.addProduction(10);
        c.addProduction(10);
        assertEquals("City have 20 productions", 20, c.getProductionValue());
    }
    @Test
    public void ShouldGiveCity6ProductionPrTurn() {
        assertEquals("0 food at start",0,game.getCityAt(redcity).getProductionValue());
        endRound();
        assertEquals("6 food at 2nd round",6,game.getCityAt(redcity).getProductionValue());
    }
    @Test
    public void ShouldProduceRedArcherAtRound2() {
        game.changeProductionInCityAt(redcity,GameConstants.ARCHER);
        assertNull("no unit yet", game.getUnitAt(redcity));
        endRound();
        assertNull("no unit yet", game.getUnitAt(redcity));
        endRound();
        Unit u1 = game.getUnitAt(redcity);
        assertNotNull("unit at (1,1)", u1);
        assertEquals("unit at (1,1) belongs to red",Player.RED,u1.getOwner());
        assertEquals("unit at (1,1) is archer", GameConstants.ARCHER,u1.getTypeString());
    }
    @Test
    public void ShouldProduceBlueLegionAtRound3BlueTurn() {
        game.changeProductionInCityAt(bluecity,GameConstants.LEGION);
        assertNull("no unit yet", game.getUnitAt(bluecity));
        endRound();
        assertNull("no unit yet2", game.getUnitAt(bluecity));
        endRound();
        assertNull("no unit yet3", game.getUnitAt(bluecity));
        endRound();
        game.endOfTurn();
        Unit u1 = game.getUnitAt(bluecity);
        assertNotNull("unit at (4,1)", u1);
        assertEquals("unit at (4,1) belongs to blue",Player.BLUE,u1.getOwner());
        assertEquals("unit at (4,1) is legion", GameConstants.LEGION,u1.getTypeString());
    }
    public void endRound() {
        game.endOfTurn();
        game.endOfTurn();
    }

    @Test
    public void shouldProduceArcherAtRound4And5And7InCircle() {
        // circle goes p1,p2,p3
        game.changeProductionInCityAt(redcity, GameConstants.ARCHER);
        Position p1 = new Position(0,1);
        Position p2 = new Position(0,2);
        Position p3 = new Position(1,2);
        endRound();
        endRound(); // already check that for round2
        assertNull("no unit (0,1)", game.getUnitAt(p1));
        assertNull("no unit(0,2)", game.getUnitAt(p2));
        assertNull("no unit at (1,2)", game.getUnitAt(p3));
        endRound();
        endRound();
        assertNotNull("unit (0,1)", game.getUnitAt(p1));
        assertNull("no unit(0,2)2", game.getUnitAt(p2));
        assertNull("no unit at (1,2)2", game.getUnitAt(p3));
        endRound();
        assertNotNull("unit (0,1)2", game.getUnitAt(p1));
        assertNotNull("unit(0,2)", game.getUnitAt(p2));
        assertNull("no unit at (1,2)3", game.getUnitAt(p3));
        endRound();
        endRound();
        assertNotNull("unit (0,1)3", game.getUnitAt(p1));
        assertNotNull("unit(0,2)2", game.getUnitAt(p2));
        assertNotNull("unit at (1,2)", game.getUnitAt(p3));

    }
}
