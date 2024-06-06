package com.vmelik.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "hotel_reservation")
public class HotelReservation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "id_hotel_room")
    private HotelRoom hotelRoom;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
