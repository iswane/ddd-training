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
		price = price.compute(level.getRate());
	}

	public Price getRoomPrice() {
		return price;
	}
}
