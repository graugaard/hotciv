package hotciv.standard;


import hotciv.framework.*;

public class GammaUnitActionStrategy implements UnitActionStrategy{
    public UnitAction returnAction(String thisUnit){
        if (thisUnit.equals(GameConstants.SETTLER)){
            return UnitAction.BUILD_CITY;
        }
        if (thisUnit.equals(GameConstants.ARCHER)){
            return UnitAction.FORTIFY;
        }
        else return null;
    }

}
