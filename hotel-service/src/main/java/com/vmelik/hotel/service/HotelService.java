package com.vmelik.hotel.service;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.request.AddHotelRequest;
import com.vmelik.hotel.model.request.UpdateHotelRequest;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    Hotel addHotel(AddHotelRequest hotel);

    Hotel findHotel(UUID id) throws HotelNotFoundException;

    List<Hotel> findHotel(String nameFilter);

    Hotel updateHotel(UUID id, UpdateHotelRequest hotel);

    Hotel deleteHotel(UUID id);
}
