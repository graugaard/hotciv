package hotciv.factories;

import hotciv.strategy.*;


public class SemiCiv implements GameFactory {

	@Override
	public AgeStrategy makeAgeStrategy() {
		return new BetaAgeStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		return new EpsilonWinnerStrategy();
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy() {
		return new GammaUnitActionStrategy();
	}

	@Override
	public AttackStrategy makeAttackStrategy() {
		return new EpsilonAttack(new RandomDie());
	}

	@Override
	public PopulationStrategy makePopulationStrategy() {
		return null;
	}

	@Override
	public ProductionStrategy makeProduction() {
		// TODO Auto-generated method stub
		return null;
	}

}
