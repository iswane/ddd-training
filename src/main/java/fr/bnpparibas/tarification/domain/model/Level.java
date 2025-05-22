package fr.bnpparibas.tarification.domain.model;

public class Level {
	public static final double RATE_LEVEL_ZERO = 0.0;
	public static final double RATE_LEVEL_ONE = 0.07;
	public static final double RATE_LEVEL_TWO = 0.22;
	public static final double RATE_LEVEL_THREE = 0.33;

	private final int number;

	public Level(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
