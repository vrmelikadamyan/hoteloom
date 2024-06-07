package com.vmelik.hotel.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String lastName;

    private String passport;

    private String phoneNumber;

    private String email;
}
