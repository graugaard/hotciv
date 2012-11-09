package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;

/**
 * Created with IntelliJ IDEA.
 * User: jakob
 * Date: 11/9/12
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CityImpl implements City{
    private Player owner;
    public CityImpl(Player owner)            {
        this.owner = owner;
    }
    public int getSize() {
        return 0;
    }

    public String getProduction() {
        return null;
    }

    public Player getOwner() {
        return owner;
    }

    public String getWorkforceFocus() {
        return null;
    }
}
