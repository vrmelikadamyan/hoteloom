package com.vmelik.hotel.service;

import com.vmelik.hotel.model.entity.HotelContactType;

public interface HotelContactTypeService {

    HotelContactType findContactType(short id);

    HotelContactType findContactType(String name);
}
