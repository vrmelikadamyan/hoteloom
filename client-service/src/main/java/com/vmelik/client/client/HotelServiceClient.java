package com.vmelik.client.client;

import com.vmelik.client.model.request.AddHotelRequest;
import com.vmelik.client.model.request.UpdateHotelRequest;
import com.vmelik.client.model.response.HotelInfoResponse;

import java.util.UUID;

public interface HotelServiceClient {

    HotelInfoResponse addHotel(AddHotelRequest hotel);

    HotelInfoResponse updateHotel(UUID hotelId, UpdateHotelRequest hotel);

    HotelInfoResponse findHotelById(UUID hotelId);

    HotelInfoResponse deleteHotel(UUID hotelId);
}
