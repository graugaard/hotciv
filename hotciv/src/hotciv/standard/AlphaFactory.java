package hotciv.standard;

import hotciv.framework.AgeStrategy;
import hotciv.framework.GameFactory;
import hotciv.framework.WinnerStrategy;

public class AlphaFactory implements GameFactory {

	@Override
	public AgeStrategy makeAgeStrategy() {
		return new AlphaAgeStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		return new AlphaWinnerStrategy();
	}


}
