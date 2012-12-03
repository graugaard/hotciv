package hotciv.factories;

import hotciv.strategy.*;


public class EpsilonFactory implements GameFactory{


    @Override
    public AgeStrategy makeAgeStrategy() {
        return new AlphaAgeStrategy();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WinnerStrategy makeWinnerStrategy() {
        return new EpsilonWinnerStrategy();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UnitActionStrategy makeUnitActionStrategy() {
        return new AlphaUnitActionStrategy();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AttackStrategy makeAttackStrategy(){
    	RandomDie r = new RandomDie();
        return new EpsilonAttack( r );
    }
    
	public PopulationStrategy makePopulationStrategy() {
		return new AlphaPopulationStrategy();
	}
}
