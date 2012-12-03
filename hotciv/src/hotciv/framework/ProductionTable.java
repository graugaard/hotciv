package hotciv.framework;

public class ProductionTable {

	public static final int production (String tileType) {
		if (tileType.equals(GameConstants.FOREST)) {
			return 3;
		}
		if (tileType.equals(GameConstants.HILLS)) {
			return 2;
		}
		if (tileType.equals(GameConstants.MOUNTAINS)) {
			return 1;
		}
		return 0;
	}
	
	public static final int food (String tileType) {
		if (tileType.equals(GameConstants.PLAINS)) {
			return 3;
		}
		if (tileType.equals(GameConstants.OCEANS)) {
			return 1;
		}
		return 0;
	}
}
