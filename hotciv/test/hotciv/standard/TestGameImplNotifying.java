package hotciv.standard;

import org.junit.*;
import static org.junit.Assert.*;

import hotciv.common.*;
import hotciv.factories.*;
import hotciv.framework.Position;
import hotciv.standard.utilities.ObserverSpy;

public class TestGameImplNotifying {
	
	GameImpl game;
	@Before
	public void setup() {
		game = new GameImpl(new AlphaFactory(), new AlphaWorldGeneration());
	}
	/*
	 * If moveunit from gameImpl returns true, then GameImpl
	 * have invoked the observers invoke worldChangeAt
	 */
	@Test
	public void ObserversShouldBeNotedOfLegalMoveUnitToEmptyTile() {
		ObserverSpy spy1 = new ObserverSpy( new Position(2,0) );
		ObserverSpy spy2 = new ObserverSpy( new Position(2,1) );
		game.addObserver(spy1);
		game.addObserver(spy2);
		
		assertFalse(spy1.worldChangeInvoked());
		assertFalse(spy2.worldChangeInvoked());
		game.moveUnit(new Position(2,0), new Position(2,1) );
		
		assertTrue(spy1.worldChangeInvoked());
		assertTrue(spy2.worldChangeInvoked());
	}
	
	@Test
	public void ObserversShouldBeInfomedOfAnAttackMove() {
		game.endOfTurn();
		
		Position blueLegion = new Position(3,2);
		Position redSettler = new Position(4,3);
		
		ObserverSpy spy1 = new ObserverSpy( blueLegion );
		ObserverSpy spy2 = new ObserverSpy( redSettler );
		game.addObserver(spy1);
		game.addObserver(spy2);
		
		assertFalse(spy1.worldChangeInvoked());
		assertFalse(spy2.worldChangeInvoked());
		
		game.moveUnit(blueLegion, redSettler);
		assertTrue(spy1.worldChangeInvoked());
		assertTrue(spy2.worldChangeInvoked());
	}
	
	@Test
	public void ObserversShouldBeNotedOfPerformUnitAction() {
		Position redSettler = new Position(4,3);
		
		ObserverSpy spy1 = new ObserverSpy( redSettler );
		game.addObserver( spy1 );
		assertFalse(spy1.worldChangeInvoked());
		
		game.performUnitActionAt( redSettler );
		assertTrue(spy1.worldChangeInvoked());
	}
	
	@Test
	public void ObserversShouldBeNotedOfTileFocusChange() {
		ObserverSpy spy1 = new ObserverSpy( new Position(0,0) );
		game.addObserver( spy1 );
		
		assertFalse( spy1.tileFocusHasChanged() );
		game.setTileFocus( new Position(0,0) );
		assertTrue( spy1.tileFocusHasChanged() );
	}
}
