package hotciv.standard;

import hotciv.common.CityImpl;
import hotciv.common.GameImpl;
import hotciv.framework.*;
import hotciv.factories.*;
import hotciv.standard.utilities.StringWorldGeneration;

import org.junit.*;
import static org.junit.Assert.*;

public class TestEtaCiv {
	GameImpl g;
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
		g = new GameImpl(new EtaFactory(), wg);
	}
	@Test
	public void ShouldAddPopulationCorrectly() {
		
		City city = g.getCityAt(new Position(0,1));
		CityImpl ci = (CityImpl) city;
		ci.addPopulation(4);
		assertEquals("5 people in city", 5, city.getSize());
		ci.addFood(5 + (5)*3);
		assertEquals("20 food in city", 20, ci.getFoodAmount());
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("6 people in city", 6, city.getSize());
		assertEquals("0 food in city", 0, ci.getFoodAmount());
	}
	
	@Test
	public void ShouldEnforcePopulationLimit() {
		City city = g.getCityAt(new Position(0,4));
		CityImpl ci = (CityImpl) city;
		ci.addPopulation(8);
		assertEquals("9 people in city", 9, city.getSize());
		ci.addFood(5 + 9*3);
		assertEquals("32 food in city", 32, ci.getFoodAmount());
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("9 people in city", 9, city.getSize());
	}
}
