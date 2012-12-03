package hotciv.factories;

import hotciv.strategy.*;


public class ZetaFactory implements GameFactory {

    @Override
    public AgeStrategy makeAgeStrategy() {
        return new AlphaAgeStrategy();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WinnerStrategy makeWinnerStrategy() {
        return new ZetaWinnerStrategy(new BetaWinnerStrategy(), new EpsilonWinnerStrategy(20));  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UnitActionStrategy makeUnitActionStrategy() {
        return new AlphaUnitActionStrategy();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AttackStrategy makeAttackStrategy() {
        return new AlphaAttack();  //To change body of implemented methods use File | Settings | File Templates.
    }

	@Override
	public PopulationStrategy makePopulationStrategy() {
		return new AlphaPopulationStrategy();
	}
	
	public ProductionStrategy makeProduction() {
		return new AlphaProduction();
	}
}
