package hotciv.strategy.utilities;

public class ProductionStack {
	private int food;
	private int production;
	
	public ProductionStack (int food, int prod) {
		this.food = food;
		this.production = prod;
	}
	
	public int getFood() {
		return food;
	}
	
	public int getProduction() {
		return production;
	}
}
