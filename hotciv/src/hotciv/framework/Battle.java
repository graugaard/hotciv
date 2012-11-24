package hotciv.framework;

public class Battle {
	private Player attacker;
	private boolean success;
	private int round;
	
	public Battle(Player attacker,
			boolean success, int round) {
		this.attacker = attacker;
		this.success = success;
		this.round = round;
	}
	
	public Player getAttacker() {
		return attacker;
	}
	
	public boolean successfull() {
		return success;
	}
	
	public int round() {
		return round;
	}
}
