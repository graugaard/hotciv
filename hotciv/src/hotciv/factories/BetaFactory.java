package hotciv.factories;

import hotciv.framework.AgeStrategy;
import hotciv.framework.GameFactory;
import hotciv.framework.UnitActionStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.standard.AlphaUnitActionStrategy;
import hotciv.standard.BetaAgeStrategy;
import hotciv.standard.BetaWinnerStrategy;

public class BetaFactory implements GameFactory {

    @Override
    public AgeStrategy makeAgeStrategy() {
        return new BetaAgeStrategy();
    }

    @Override
    public WinnerStrategy makeWinnerStrategy() {
        return new BetaWinnerStrategy();
    }

    public UnitActionStrategy makeUnitActionStrategy() {
        return new AlphaUnitActionStrategy();
    }

}
