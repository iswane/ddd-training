package fr.bnpparibas.tarification.driven;

import fr.bnpparibas.tarification.domain.model.Motel;
import fr.bnpparibas.tarification.domain.port.driven.ForModifyingRoomsPrice;

public class ModifyRoomsPriceSpy
        implements ForModifyingRoomsPrice {

    private Motel motel;

    public ModifyRoomsPriceSpy(Motel motel) {
        this.motel = motel;
    }

    @Override
    public void putMotel(final Motel motel) {
        this.motel = motel;
    }

    public Motel getMotel() {
        return motel;
    }
}
