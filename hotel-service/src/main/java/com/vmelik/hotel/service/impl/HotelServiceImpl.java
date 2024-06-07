package com.vmelik.hotel.service.impl;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.request.AddHotelRequest;
import com.vmelik.hotel.model.request.UpdateHotelRequest;
import com.vmelik.hotel.repository.HotelRepository;
import com.vmelik.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    @Transactional
    public Hotel addHotel(AddHotelRequest hotel) {
        Hotel newHotel = new Hotel();
        newHotel.setName(hotel.getName());
        newHotel.setStarRating(hotel.getStarRating());
        newHotel.setDescription(hotel.getDescription());
        newHotel.setAddress(hotel.getAddress());

        return hotelRepository.save(newHotel);
    }

    @Override
    public Hotel findHotel(UUID id) throws HotelNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id = %s not found!".formatted(id)));
    }

    @Override
    public List<Hotel> findHotel(String nameFilter) {
        // TODO implement
        return List.of();
    }

    @Override
    @Transactional
    public Hotel updateHotel(UUID id, UpdateHotelRequest hotelUpdate) {
        Hotel hotel = findHotel(id);

        hotel.setName(hotelUpdate.getName());
        hotel.setStarRating(hotelUpdate.getStarRating());
        hotel.setDescription(hotelUpdate.getDescription());
        hotel.setAddress(hotel.getAddress());

        return hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public Hotel deleteHotel(UUID id) {
        Hotel hotel = findHotel(id);
        hotelRepository.delete(hotel);

        return hotel;
    }
}
