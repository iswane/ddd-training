package fr.bnpparibas.tarification.domain.model;

public class Price {
	private static final double AMOUNT_PLAFOND = 200;

	private final double value;

	public Price(double value) {
		this.value = value;
	}

	public Price compute(double rate) {
		var result = this.value + this.value * rate;
		if (result > AMOUNT_PLAFOND) {
			return new Price(AMOUNT_PLAFOND);
		} else {
			return new Price(result);
		}
	}

	public double getValue() {
		return value;
	}
}
