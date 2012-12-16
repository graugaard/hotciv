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
	private boolean worldChangedAtPosInvoked;
	private boolean tileFocusHasChanged;
	private Player nextPlayer;
	private int age;
	private Position positionObserved;
	
	public ObserverSpy( Position p ) {
		worldChangedAtPosInvoked = false;
		tileFocusHasChanged = false;
		positionObserved = p;
	}

	public void worldChangedAt(Position pos) {
		
		if (pos.equals(positionObserved)) {
			worldChangedAtPosInvoked = true;
		}
	}

	public void turnEnds(Player nextPlayer, int age) {
		this.nextPlayer = nextPlayer;
		this.age = age;
	}

	public void tileFocusChangedAt(Position position) {
		
		if ( position.equals( positionObserved )) {
			tileFocusHasChanged = true;
		}
	}
	
	public boolean worldChangeInvoked() {
		return worldChangedAtPosInvoked;
	}
	
	public boolean tileFocusHasChanged() {
		return tileFocusHasChanged;
	}
	
	public Player getNextPlayer() {
		return nextPlayer;
	}
	
	public int getAge() {
		return age;
	}
}
