package hotciv.factories;

import hotciv.strategy.*;

public class EtaFactory implements GameFactory {

	@Override
	public AgeStrategy makeAgeStrategy() {
		return new AlphaAgeStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		// TODO Auto-generated method stub
		return new AlphaWinnerStrategy();
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy() {
		// TODO Auto-generated method stub
		return new AlphaUnitActionStrategy();
	}

	@Override
	public AttackStrategy makeAttackStrategy() {
		// TODO Auto-generated method stub
		return new AlphaAttack();
	}

	@Override
	public PopulationStrategy makePopulationStrategy() {
		// TODO Auto-generated method stub
		return new EtaPopulationStrategy();
	}
	
	public ProductionStrategy makeProduction() {
		return new EtaProduction();
	}

}
