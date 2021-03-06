package hotciv.strategy;

import hotciv.common.CityImpl;
import hotciv.common.UnitImpl;
import hotciv.framework.*;

public class GammaUnitActionStrategy implements UnitActionStrategy{
    public boolean returnAction(Position p, ExtendedGame thisGame){
        if (thisGame.getUnitAt(p) == null){
            return false;
        }
        Unit unit = thisGame.getUnitAt(p);

        if (unit.getTypeString().equals(GameConstants.SETTLER)) {
            if (thisGame.getCityAt(p) != null) {
                return false;
            }
            thisGame.removeUnitAt(p);
            thisGame.addCity(new CityImpl(unit.getOwner()),p);
            return true;
        }
        if (unit.getTypeString().equals(GameConstants.ARCHER)) {
            UnitImpl u = (UnitImpl) unit;
            u.setFortify();
            return true;
        }
        return false;
    }

}
