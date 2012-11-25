package hotciv.factories;

import hotciv.strategy.*;

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

	public AttackStrategy makeAttackStrategy() {
		return new AlphaAttack();
	}
}
