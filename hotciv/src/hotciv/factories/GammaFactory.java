package hotciv.factories;

import hotciv.framework.AgeStrategy;
import hotciv.framework.GameFactory;
import hotciv.framework.UnitActionStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.standard.AlphaAgeStrategy;
import hotciv.standard.AlphaWinnerStrategy;
import hotciv.standard.GammaUnitActionStrategy;

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
