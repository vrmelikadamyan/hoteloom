package com.vmelik.hotel.service.impl;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.entity.HotelRoomType;
import com.vmelik.hotel.repository.HotelRoomTypeRepository;
import com.vmelik.hotel.service.HotelRoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelRoomTypeServiceImpl implements HotelRoomTypeService {
    private final HotelRoomTypeRepository hotelRoomTypeRepository;

    @Override
    public HotelRoomType findHotelRoomType(short id) {
        return hotelRoomTypeRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel room type with id = %d not found!".formatted(id)));
    }
}
