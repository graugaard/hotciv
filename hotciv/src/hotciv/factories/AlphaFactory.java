package hotciv.factories;

import hotciv.framework.AgeStrategy;
import hotciv.framework.GameFactory;
import hotciv.framework.UnitActionStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.standard.AlphaAgeStrategy;
import hotciv.standard.AlphaUnitActionStrategy;
import hotciv.standard.AlphaWinnerStrategy;

public class AlphaFactory implements GameFactory {

	@Override
	public AgeStrategy makeAgeStrategy() {
		return new AlphaAgeStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		return new AlphaWinnerStrategy();
	}

    public UnitActionStrategy makeUnitActionStrategy() {
        return new AlphaUnitActionStrategy();
    }


}
