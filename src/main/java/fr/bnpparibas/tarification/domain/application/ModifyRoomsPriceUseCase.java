package fr.bnpparibas.tarification.domain.application;

import fr.bnpparibas.tarification.domain.model.Motel;
import fr.bnpparibas.tarification.domain.port.driven.ForGettingRooms;
import fr.bnpparibas.tarification.domain.port.driven.ForModifyingRoomsPrice;
import fr.bnpparibas.tarification.domain.port.driving.ForModifyingRoomPrice;

public class ModifyRoomsPriceUseCase
		implements ForModifyingRoomPrice {

	private final ForGettingRooms forGettingRooms;
	private final ForModifyingRoomsPrice forModifyingRoomsPrice;

	public ModifyRoomsPriceUseCase(
			final ForGettingRooms forGettingRooms,
			final ForModifyingRoomsPrice forModifyingRoomsPrice) {
		this.forGettingRooms = forGettingRooms;
		this.forModifyingRoomsPrice = forModifyingRoomsPrice;
	}

	@Override
	public void execute(final double roomPriceRDC) {
		final Motel motel = forGettingRooms.getMotel();
		motel.modifyPrices(roomPriceRDC);
		forModifyingRoomsPrice.putMotel(motel);
	}
}
