package com.vmelik.hotel.repository;

import com.vmelik.hotel.model.entity.HotelContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelContactRepository extends JpaRepository<HotelContact, UUID> {
}
