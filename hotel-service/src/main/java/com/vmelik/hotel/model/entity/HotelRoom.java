package com.vmelik.hotel.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "hotel_room")
public class HotelRoom {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    private short roomNumber;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_hotel_room_type")
    private HotelRoomType hotelRoomType;
}
