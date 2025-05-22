package fr.bnpparibas.tarification.driven;

import fr.bnpparibas.tarification.domain.model.Motel;
import fr.bnpparibas.tarification.domain.port.driven.ForGettingRooms;

public class GettingRoomsStub
		implements ForGettingRooms {

     private Motel motel;

	public GettingRoomsStub(Motel motel) {
		this.motel = motel;
	}

	@Override
	public Motel getMotel() {
		return motel;
	}

}
