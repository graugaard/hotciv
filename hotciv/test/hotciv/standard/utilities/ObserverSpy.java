package hotciv.standard.utilities;

import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;

/**
 * A spy meant to test that game invokes worldChangedAt correctly;
 * @author jakob
 *
 */
public class ObserverSpy implements GameObserver {
	private boolean worldChangedAtInvoked;
	private Position positionObserved;
	public ObserverSpy( Position p ) {
		worldChangedAtInvoked = false;
		positionObserved = p;
	}
	@Override
	public void worldChangedAt(Position pos) {
		
		if (pos.equals(positionObserved)) {
			worldChangedAtInvoked = true;
		}
	}

	@Override
	public void turnEnds(Player nextPlayer, int age) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tileFocusChangedAt(Position position) {
		// TODO Auto-generated method stub

	}
	
	public boolean worldChangeInvoked() {
		return worldChangedAtInvoked;
	}
}
