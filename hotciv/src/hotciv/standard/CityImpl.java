package hotciv.standard;

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

    public CityImpl(Player owner) {
        this.owner = owner;
        producing = GameConstants.SETTLER;
    }

    public int getSize() {
        return 1;
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


}
