package com.vmelik.hotel.service.impl;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.entity.HotelContactType;
import com.vmelik.hotel.repository.HotelContactTypeRepository;
import com.vmelik.hotel.service.HotelContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelContactTypeServiceImpl implements HotelContactTypeService {
    private final HotelContactTypeRepository hotelContactTypeRepository;

    @Override
    public HotelContactType findContactType(short id) {
        return hotelContactTypeRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Contact with type id = %d not found!".formatted(id)));
    }

    @Override
    public HotelContactType findContactType(String name) {
        List<HotelContactType> contactTypeSearchResult = hotelContactTypeRepository.findByName(name);

        if (contactTypeSearchResult.isEmpty()) {
            throw new HotelNotFoundException("Contact type with name = %s not found!".formatted(name));
        }

        return contactTypeSearchResult.get(0);
    }
}
