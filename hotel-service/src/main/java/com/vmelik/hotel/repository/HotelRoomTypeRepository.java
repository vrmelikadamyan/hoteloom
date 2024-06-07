package com.vmelik.hotel.repository;

import com.vmelik.hotel.model.entity.HotelRoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomTypeRepository extends JpaRepository<HotelRoomType, Short> {
}
