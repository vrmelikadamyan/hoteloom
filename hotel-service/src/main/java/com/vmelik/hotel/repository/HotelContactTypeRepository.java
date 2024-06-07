package com.vmelik.hotel.repository;

import com.vmelik.hotel.model.entity.HotelContactType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelContactTypeRepository extends JpaRepository<HotelContactType, Short> {

    List<HotelContactType> findByName(String name);
}
