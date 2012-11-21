package hotciv.standard;

import hotciv.framework.AgeStrategy;
import hotciv.framework.GameFactory;
import hotciv.framework.UnitActionStrategy;
import hotciv.framework.WinnerStrategy;

public class GammaFactory implements GameFactory{
    public AgeStrategy makeAgeStrategy() {
        return new AlphaAgeStrategy();
    }


    public WinnerStrategy makeWinnerStrategy() {
        return new AlphaWinnerStrategy();
    }

    public UnitActionStrategy makeUnitActionStrategy() {
        return new GammaUnitActionStrategy();
    }
}
