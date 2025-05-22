package fr.bnpparibas.tarification;

import fr.bnpparibas.tarification.domain.application.ModifyRoomsPriceUseCase;
import fr.bnpparibas.tarification.domain.model.Level;
import fr.bnpparibas.tarification.domain.model.Motel;
import fr.bnpparibas.tarification.domain.model.Price;
import fr.bnpparibas.tarification.domain.model.Room;
import fr.bnpparibas.tarification.domain.port.driven.ForGettingRooms;
import fr.bnpparibas.tarification.domain.port.driving.ForModifyingRoomPrice;
import fr.bnpparibas.tarification.driven.GettingRoomsStub;
import fr.bnpparibas.tarification.driven.ModifyRoomsPriceSpy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ModifyingRoomPriceTest {

    Motel motel;

    @Test
    void shouldReturnPriceRoomEqual100WhenThePriceRoomRDCIsSetAt100() {
        // Given
        double roomPriceRDC = 100;
        motel = new Motel(List.of(new Room("001", new Level(0), new Price(0))));
        ForGettingRooms gettingRoomsStub = new GettingRoomsStub(motel);
        ModifyRoomsPriceSpy modifyingRoomsPriceSpy = new ModifyRoomsPriceSpy(motel);
        ForModifyingRoomPrice sut = new ModifyRoomsPriceUseCase(gettingRoomsStub, modifyingRoomsPriceSpy);

        // When
        sut.execute(roomPriceRDC);
        var roomPriceExpected = modifyingRoomsPriceSpy.getMotel().getRooms().getFirst().getRoomPrice();

        //Then
        assertEquals(roomPriceRDC, roomPriceExpected.getValue());
    }

    @Test
    void shouldReturnPriceRoomEqual107WhenThePriceRoomRDCIsSetAt100BecauseAdded7PercentOfPriceRDCRoomInLevel1() {
        // Given
        double roomPriceRDC = 100;
        double roomPriceLevelOne = 107;
        motel = new Motel(List.of(new Room("101", new Level(1), new Price(0))));
        ForGettingRooms gettingRoomsStub = new GettingRoomsStub(motel);
        ModifyRoomsPriceSpy modifyingRoomsPriceSpy = new ModifyRoomsPriceSpy(motel);
        ForModifyingRoomPrice sut = new ModifyRoomsPriceUseCase(gettingRoomsStub, modifyingRoomsPriceSpy);

        // When
        sut.execute(roomPriceRDC);
        var roomPriceExpected = modifyingRoomsPriceSpy.getMotel().getRooms().getFirst().getRoomPrice();

        //Then
        assertEquals(roomPriceLevelOne, roomPriceExpected.getValue());
    }

    @Test
    void shouldReturnPriceRoomEqual122WhenThePriceRoomRDCIsSetAt100BecauseAdded22PercentOfPriceRDCRoomInLevel2() {
        // Given
        double roomPriceRDC = 100;
        double roomPriceLevelTwo = 122;
        motel = new Motel(List.of(new Room("202", new Level(2), new Price(0))));
        ForGettingRooms gettingRoomsStub = new GettingRoomsStub(motel);
        ModifyRoomsPriceSpy modifyingRoomsPriceSpy = new ModifyRoomsPriceSpy(motel);
        ForModifyingRoomPrice sut = new ModifyRoomsPriceUseCase(gettingRoomsStub, modifyingRoomsPriceSpy);

        // When
        sut.execute(roomPriceRDC);
        var roomPriceExpected = modifyingRoomsPriceSpy.getMotel().getRooms().getFirst().getRoomPrice();

        //Then
        assertEquals(roomPriceLevelTwo, roomPriceExpected.getValue());
    }

    @Test
    void shouldReturnPriceRoomEqual133WhenThePriceRoomRDCIsSetAt100BecauseAdded33PercentOfPriceRDCRoomInLevel3() {
        // Given
        double roomPriceRDC = 100;
        double roomPriceLevelThree = 133;
        motel = new Motel(List.of(new Room("303", new Level(3), new Price(0))));
        ForGettingRooms gettingRoomsStub = new GettingRoomsStub(motel);
        ModifyRoomsPriceSpy modifyingRoomsPriceSpy = new ModifyRoomsPriceSpy(motel);
        ForModifyingRoomPrice sut = new ModifyRoomsPriceUseCase(gettingRoomsStub, modifyingRoomsPriceSpy);

        // When
        sut.execute(roomPriceRDC);
        var roomPriceExpected = modifyingRoomsPriceSpy.getMotel().getRooms().getFirst().getRoomPrice();

        //Then
        assertEquals(roomPriceLevelThree, roomPriceExpected.getValue());
    }

    @Test
    void shouldReturnPriceRoomEqual200WhenThePriceRoomRDCIsSettingButTheComputeExcededLimit() {
        // Given
        double roomPriceRDC = 170;
        double roomPriceLevelThree = 200;
        motel = new Motel(List.of(new Room("303", new Level(3), new Price(0))));
        ForGettingRooms gettingRoomsStub = new GettingRoomsStub(motel);
        ModifyRoomsPriceSpy modifyingRoomsPriceSpy = new ModifyRoomsPriceSpy(motel);
        ForModifyingRoomPrice sut = new ModifyRoomsPriceUseCase(gettingRoomsStub, modifyingRoomsPriceSpy);

        // When
        sut.execute(roomPriceRDC);
        var roomPriceExpected = modifyingRoomsPriceSpy.getMotel().getRooms().getFirst().getRoomPrice();

        //Then
        assertEquals(roomPriceLevelThree, roomPriceExpected.getValue());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenLevelISNotValid() {
        // Given
        double roomPriceRDC = 170;
        motel = new Motel(List.of(new Room("303", new Level(10), new Price(0))));
        ForGettingRooms gettingRoomsStub = new GettingRoomsStub(motel);
        ModifyRoomsPriceSpy modifyingRoomsPriceSpy = new ModifyRoomsPriceSpy(motel);
        ForModifyingRoomPrice sut = new ModifyRoomsPriceUseCase(gettingRoomsStub, modifyingRoomsPriceSpy);

        // When
        //Then
        var exception = assertThrows(IllegalArgumentException.class, () -> sut.execute(roomPriceRDC));
        assertEquals("Level number not supported", exception.getMessage());
    }
}
