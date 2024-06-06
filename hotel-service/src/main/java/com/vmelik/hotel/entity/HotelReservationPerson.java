package com.vmelik.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "hotel_reservation_person")
public class HotelReservationPerson {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_hotel_reservation")
    private HotelReservation hotelReservation;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
}
