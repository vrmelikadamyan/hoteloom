package com.vmelik.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private short starRating;

    private String description;

    private String address;

    private LocalDateTime additionDate;
}
