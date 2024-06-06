package com.vmelik.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "hotel_contact")
public class HotelContact {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "id_hotel_contact_type")
    private HotelContactType contactType;

    @Column(name = "contact_value")
    private String value;
}
