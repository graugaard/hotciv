package hotciv.standard;

import org.junit.*;
import static org.junit.Assert.*;

import hotciv.common.*;
import hotciv.factories.*;
import hotciv.framework.Position;
import hotciv.standard.utilities.ObserverSpy;

public class TestGameImplNotifying {

	/*
	 * If moveunit from gameImpl returns true, then GameImpl
	 * have invoked the observers invoke worldChangeAt
	 */
	@Test
	public void worldChangeAtInvokedAtLegalMoveUnit() {
		GameImpl game = new GameImpl(new AlphaFactory(), new AlphaWorldGeneration());
		ObserverSpy spy = new ObserverSpy( new Position(1,2) );
		game.addObserver(spy);
		
		game.moveUnit(new Position(1,1), new Position(1,2) );
		
		assertTrue(spy.worldChangeInvoked());
	}
}
