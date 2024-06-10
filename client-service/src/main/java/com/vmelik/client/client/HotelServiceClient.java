package com.vmelik.client.client;

import com.vmelik.client.model.request.AddHotelContactRequest;
import com.vmelik.client.model.request.AddHotelRequest;
import com.vmelik.client.model.request.UpdateHotelContactRequest;
import com.vmelik.client.model.request.UpdateHotelRequest;
import com.vmelik.client.model.response.HotelContactInfoResponse;
import com.vmelik.client.model.response.HotelInfoResponse;

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
}
