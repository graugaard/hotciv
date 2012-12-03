package hotciv.factories;

import hotciv.strategy.AgeStrategy;
import hotciv.strategy.AlphaPopulationStrategy;
import hotciv.strategy.AttackStrategy;
import hotciv.strategy.GammaUnitActionStrategy;
import hotciv.strategy.AlphaAgeStrategy;
import hotciv.strategy.AlphaAttack;
import hotciv.strategy.AlphaWinnerStrategy;
import hotciv.strategy.PopulationStrategy;
import hotciv.strategy.UnitActionStrategy;
import hotciv.strategy.WinnerStrategy;

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
    
    public AttackStrategy makeAttackStrategy() {
		return new AlphaAttack();
	}
    
	public PopulationStrategy makePopulationStrategy() {
		return new AlphaPopulationStrategy();
	}
}
