package hotciv.standard;

import hotciv.common.CityImpl;
import hotciv.common.GameImpl;
import hotciv.factories.EtaFactory;
import hotciv.framework.*;
import hotciv.standard.utilities.StringWorldGeneration;

import org.junit.*;

import static org.junit.Assert.*;

public class TestLogDecorator {
	Game g;
	String[] t = { 	".....",
					".....",
					".....",
					"....." };
	String[] c = { 	".R..B",
					".....",
					".....",
					".....", };
	String[] u = t;
	@Before
	public void setUp() {
		WorldGeneration wg = new StringWorldGeneration(t, c, u);
		g = new LogDecorator(
				new GameImpl(new EtaFactory(), wg)
				);
	}
	
	
	
	
	@Test
	public void ShouldHandleProductionFocusCorrect() {
		String[] tiles = { 	".h.oo",
							".Mffo",
							"....." };
		String[] cities = {	".....",
							"..R..",
							"....."};
		String[] units = { 	".aA..",
							".....",
							".L..." };
		WorldGeneration wg = new StringWorldGeneration(tiles, cities, units);
		g = new LogDecorator(new GameImpl(new EtaFactory(), wg));
		Position p = new Position(1,2);
		g.changeWorkForceFocusInCityAt(p, GameConstants.productionFocus);
		CityImpl city = (CityImpl) g.getCityAt(p);
		city.addPopulation(2);
		g.moveUnit(new Position(0, 2), new Position(1, 2));
		g.endOfTurn();
		g.moveUnit(new Position(0, 1), new Position(1, 0));
		g.endOfTurn();		
		LogDecorator game = (LogDecorator) g;
		System.out.println(game.getLog());
	}
	
	

}
