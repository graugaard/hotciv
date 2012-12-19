package hotciv.view;

import java.awt.Point;
import java.util.HashMap;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.StandardDrawing;

public class CityDrawing extends StandardDrawing implements Drawing,
		GameObserver {
	Game game;
	public CityDrawing( Game game, DrawingEditor editor) {
		super();
		this.game = game;
		game.addObserver(this);
	}
	protected HashMap<City,CityFigure> cityMap;
	public void defineCityMap() {
		for (int r = 0; r < GameConstants.WORLDSIZE; r++) {
			for (int c = 0; c < GameConstants.WORLDSIZE; c++) {
				Position p = new Position( r, c );
				int x = GfxConstants.getXFromColumn(c);
				int y = GfxConstants.getYFromRow(r);
				Point point = new Point(x,y);
				City city = game.getCityAt(p);
				if ( city != null ) {
					CityFigure cf = new CityFigure(city, point);
					cf.addFigureChangeListener(this);
					cityMap.put(city,cf);
					
					super.add(cf);
				}
			}
		}
	}
	@Override
	public void worldChangedAt(Position pos) {
		System.out.println( "UnitDrawing: world changes at "+pos);
	    clearSelection();
	    // this is a really brute-force algorithm: destroy
	    // all known units and build up the entire set again
	    for ( Figure f : cityMap.values() ) {
	      super.remove(f);
	    }
	    defineCityMap();

	}

	@Override
	public void turnEnds(Player nextPlayer, int age) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tileFocusChangedAt(Position position) {
		// TODO Auto-generated method stub

	}

}
