package hotciv.standard;


import hotciv.framework.*;

public class GammaUnitActionStrategy implements UnitActionStrategy{
    public UnitAction returnAction(Unit thisUnit){
        String unit =thisUnit.getTypeString();
        if (unit.equals(GameConstants.SETTLER)){
            return UnitAction.BUILD_CITY;
        }
        if (unit.equals(GameConstants.ARCHER)){
            return UnitAction.FORTIFY;
        }
        else return null;
    }

}
