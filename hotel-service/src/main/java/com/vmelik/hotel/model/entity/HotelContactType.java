package com.vmelik.hotel.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hotel_contact_type")
public class HotelContactType {

    @Id
    private short id;

    private String name;
}
