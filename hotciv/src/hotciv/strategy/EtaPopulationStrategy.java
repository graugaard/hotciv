package hotciv.strategy;

public class EtaPopulationStrategy implements PopulationStrategy {

	public int nextPopulationIncrease(int populationSize) {
		return 5 + 3*populationSize;
	}

	public int populationLimit() {
		return 9;
	}

}
