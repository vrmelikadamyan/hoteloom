package com.vmelik.client.client;

import com.vmelik.client.model.request.*;
import com.vmelik.client.model.response.HotelContactInfoResponse;
import com.vmelik.client.model.response.HotelInfoResponse;
import com.vmelik.client.model.response.HotelRoomInfoResponse;

import java.util.UUID;

public interface HotelServiceClient {

    HotelInfoResponse addHotel(AddHotelRequest hotel);

    HotelInfoResponse updateHotel(UUID hotelId, UpdateHotelRequest hotel);

    HotelInfoResponse findHotelById(UUID hotelId);

    HotelInfoResponse deleteHotel(UUID hotelId);

    HotelContactInfoResponse addContact(AddHotelContactRequest addHotelContactRequest);

    HotelContactInfoResponse findContact(UUID contactId);

    HotelContactInfoResponse updateContact(UUID contactId, UpdateHotelContactRequest updateHotelContactRequest);

    HotelContactInfoResponse deleteContact(UUID contactId);

    HotelRoomInfoResponse addHotelRoom(AddHotelRoomRequest request);

    HotelRoomInfoResponse findHotelRoom(UUID roomId);

    HotelRoomInfoResponse updateHotelRoom(UUID roomId, UpdateHotelRoomRequest request);

    HotelRoomInfoResponse deleteHotelRoom(UUID roomId);
}
