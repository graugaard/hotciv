package hotciv.standard;

import hotciv.framework.AgeStrategy;
import hotciv.framework.GameFactory;
import hotciv.framework.WinnerStrategy;

public class BetaFactory implements GameFactory {

    @Override
    public AgeStrategy makeAgeStrategy() {
        return new BetaAgeStrategy();
    }

    @Override
    public WinnerStrategy makeWinnerStrategy() {
        return new BetaWinnerStrategy();
    }

}
