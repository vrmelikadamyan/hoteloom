package com.vmelik.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "hotel_room_type")
public class HotelRoomType {

    @Id
    private short id;

    private String name;

    private String description;

    private Integer cost;
}
