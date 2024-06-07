package com.vmelik.hotel.repository;

import com.vmelik.hotel.model.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, UUID> {
}
