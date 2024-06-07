package com.vmelik.hotel.service.impl;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.entity.HotelRoom;
import com.vmelik.hotel.model.entity.HotelRoomType;
import com.vmelik.hotel.model.request.AddHotelRoomRequest;
import com.vmelik.hotel.model.request.UpdateHotelRoomRequest;
import com.vmelik.hotel.repository.HotelRoomRepository;
import com.vmelik.hotel.service.HotelRoomService;
import com.vmelik.hotel.service.HotelRoomTypeService;
import com.vmelik.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelRoomServiceImpl implements HotelRoomService {
    private final HotelService hotelService;
    private final HotelRoomTypeService hotelRoomTypeService;
    private final HotelRoomRepository hotelRoomRepository;

    @Override
    @Transactional
    public HotelRoom addRoom(UUID hotelId, AddHotelRoomRequest hotelRoom) {
        Hotel hotel = hotelService.findHotel(hotelId);
        HotelRoomType roomType = hotelRoomTypeService.findHotelRoomType(hotelRoom.getRoomTypeId());

        HotelRoom newRoom = new HotelRoom();
        newRoom.setHotel(hotel);
        newRoom.setRoomNumber(hotelRoom.getRoomNumber());
        newRoom.setDescription(hotelRoom.getDescription());
        newRoom.setHotelRoomType(roomType);

        return hotelRoomRepository.save(newRoom);
    }

    @Override
    public HotelRoom findRoom(UUID roomId) {
        return hotelRoomRepository.findById(roomId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel room with id = %s not found!".formatted(roomId)));
    }

    @Override
    @Transactional
    public HotelRoom updateRoom(UUID roomId, UpdateHotelRoomRequest hotelRoom) {
        HotelRoom room = findRoom(roomId);
        HotelRoomType roomType = hotelRoomTypeService.findHotelRoomType(hotelRoom.getRoomTypeId());

        room.setRoomNumber(hotelRoom.getRoomNumber());
        room.setDescription(hotelRoom.getDescription());
        room.setHotelRoomType(roomType);

        return hotelRoomRepository.save(room);
    }

    @Override
    @Transactional
    public HotelRoom deleteRoom(UUID roomId) {
        HotelRoom room = findRoom(roomId);
        hotelRoomRepository.delete(room);

        return room;
    }
}
