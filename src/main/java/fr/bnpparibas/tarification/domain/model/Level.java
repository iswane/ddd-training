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

	public double getRate() {
		switch (number) {
			case 0:
				return RATE_LEVEL_ZERO;
			case 1:
				return RATE_LEVEL_ONE;
			case 2:
				return RATE_LEVEL_TWO;
			case 3:
				return RATE_LEVEL_THREE;
			default:
				throw new IllegalArgumentException("Level number not supported");
		}
	}
}
