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
	
	@Test
	public void ShouldGiveCorrectCityProduction() {
		CityImpl city = (CityImpl) g.getCityAt(new Position(0,1));
		assertEquals("No food", 0, city.getFoodAmount());
		assertEquals("No production", 0, city.getProductionValue());
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("1 food", 1, city.getFoodAmount());
		assertEquals("1 production", 1, city.getProductionValue());
	}
	
	@Test
	public void ShouldHandleFoodFocusCorrect() {
		String[] tiles = { 	".h.OO",
							".MffO",
							"....." };
		String[] cities = {	".....",
							"..R..",
							"....."};
		String[] units = { 	".....",
							".....",
							"....." };
		WorldGeneration wg = new StringWorldGeneration(tiles, cities, units);
		g = new GameImpl(new EtaFactory(), wg);
		Position p = new Position(1,2);
		g.changeWorkForceFocusInCityAt(p, GameConstants.foodFocus);
		CityImpl city = (CityImpl) g.getCityAt(p);
		city.addPopulation(2);
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("7 food", 7, city.getFoodAmount());
		assertEquals("1 production", 1, city.getProductionValue());
	}
	
	@Test
	public void ShouldHandleProductionFocusCorrect() {
		String[] tiles = { 	".h.oo",
							".Mffo",
							"....." };
		String[] cities = {	".....",
							"..R..",
							"....."};
		String[] units = { 	".....",
							".....",
							"....." };
		WorldGeneration wg = new StringWorldGeneration(tiles, cities, units);
		g = new GameImpl(new EtaFactory(), wg);
		Position p = new Position(1,2);
		g.changeWorkForceFocusInCityAt(p, GameConstants.productionFocus);
		CityImpl city = (CityImpl) g.getCityAt(p);
		city.addPopulation(2);
		assertEquals("0 food", 0, city.getFoodAmount());
		assertEquals("0 production", 0, city.getProductionValue());
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("1 food", 1, city.getFoodAmount());
		assertEquals("1 + 3 + 2 = 6 production", 6, city.getProductionValue());
	}
	
	@Test
	public void ShouldWorkTilesClosestFirst() {
		String[] tiles = {	"OOOOOMfffff" };
		String[] cities = {	".....B....." };
		String[] units = {	"..........." };
		WorldGeneration wg = new StringWorldGeneration( tiles, cities, units );
		g = new GameImpl(new EtaFactory(), wg );
		Position p = new Position(0,5);
		CityImpl city = (CityImpl) g.getCityAt(p);
		city.addPopulation(5);
		city.setWorkforceFocus(GameConstants.foodFocus);
		g.endOfTurn(); // first round ignores blue production
		g.endOfTurn();
		g.endOfTurn();
		assertEquals("4 food", 4, city.getFoodAmount());
		assertEquals("7 production", 7, city.getProductionValue());
	}
}
