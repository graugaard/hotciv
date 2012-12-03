package hotciv.common;

import hotciv.framework.*;

/**
 * Created with IntelliJ IDEA.
 * User: jakob
 * Date: 11/9/12
 * Time: 1:25 PM
 */
public class CityImpl implements City {
    private Player owner;
    private String producing;
    private int production;
    private int population;
    private int food;

    public CityImpl(Player owner) {
        this.owner = owner;
        producing = GameConstants.SETTLER;
        production = 0;
        population = 1;
        food = 0;
    }

    public int getSize() {
        return population;
    }

    public String getProduction() {
        return producing;
    }

    public Player getOwner() {
        return owner;
    }

    public String getWorkforceFocus() {
        return null;
    }

    public void setProduction(String unitType){
        producing = unitType;
    }

    public void addProduction(int amount) {
        production += amount;
    }
    
    public int getProductionValue() {
        return production;
    }
    
    public void addPopulation(int amount) {
    	population += amount;
    }

    public void addFood( int amount ) {
    	food += amount;
    }
    
    public int getFoodAmount() {
    	return food;
    }
}
