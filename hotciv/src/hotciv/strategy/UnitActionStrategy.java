package hotciv.strategy;

import hotciv.framework.Unit;
import hotciv.framework.UnitAction;



public interface UnitActionStrategy {
    public UnitAction returnAction(Unit thisUnit);
}
