package fr.bnpparibas.tarification.domain.model;

public class Room {
	private String number;
	private final Level level;
	private Price price;

	public Room(
			final String number,
			final Level level,
			final Price price) {
		this.number = number;
		this.level = level;
		this.price = price;
	}

	public void computePrice(double roomPriceRdc) {
		price = new Price(roomPriceRdc);
		if (level.getNumber() == 0) {
			price = price.compute(Level.RATE_LEVEL_ZERO);
		} else if (level.getNumber() == 1) {
			price = price.compute(Level.RATE_LEVEL_ONE);
		} else if (level.getNumber() == 2) {
			price = price.compute(Level.RATE_LEVEL_TWO);
		} else if (level.getNumber() == 3) {
			price = price.compute(Level.RATE_LEVEL_THREE);
		} else {
			throw new IllegalArgumentException("Level number not supported");
		}
	}

	public Price getRoomPrice() {
		return price;
	}
}
