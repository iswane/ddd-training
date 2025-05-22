package fr.bnpparibas.tarification.domain.model;

import java.util.List;

public class Motel {
	private List<Room> rooms;

	public Motel(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void modifyPrices(double roomPriceRdc) {
		rooms.forEach(room -> room.computePrice(roomPriceRdc));
	}

	public List<Room> getRooms() {
		return rooms;
	}
}
