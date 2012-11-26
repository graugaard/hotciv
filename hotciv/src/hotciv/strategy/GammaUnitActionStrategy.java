package hotciv.strategy;


import hotciv.common.GameImpl;
import hotciv.common.CityImpl;
import hotciv.common.UnitImpl;
import hotciv.framework.*;

public class GammaUnitActionStrategy implements UnitActionStrategy{
    public boolean returnAction(Position p, Game thisGame){
        if (thisGame.getUnitAt(p) != null){
            Unit unit = thisGame.getUnitAt(p);

            if (unit.getTypeString().equals(GameConstants.SETTLER)){
                if (thisGame.getCityAt(p) != null) {
                    return false;
                }
                else {
                GameImpl g = (GameImpl) thisGame;
                g.removeUnitAt(p);
                g.addCity(new CityImpl(unit.getOwner()),p);
                return true;
                }
            }
            if (unit.getTypeString().equals(GameConstants.ARCHER)){
                UnitImpl u = (UnitImpl) unit;
                u.setFortify();
                return true;
            }
            else return false;
        }
        return false;
    }

}
