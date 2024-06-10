package com.vmelik.hotel.service;

import com.vmelik.hotel.model.entity.HotelRoom;
import com.vmelik.hotel.model.request.AddHotelRoomRequest;
import com.vmelik.hotel.model.request.UpdateHotelRoomRequest;

import java.util.UUID;

public interface HotelRoomService {

    HotelRoom addRoom(AddHotelRoomRequest hotelRoom);

    HotelRoom findRoom(UUID roomId);

    HotelRoom updateRoom(UUID roomId, UpdateHotelRoomRequest hotelRoom);

    HotelRoom deleteRoom(UUID roomId);
}
