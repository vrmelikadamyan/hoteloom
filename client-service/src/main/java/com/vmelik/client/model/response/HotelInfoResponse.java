package com.vmelik.client.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelInfoResponse {

    private UUID id;

    private String name;

    private short starRating;

    private String description;

    private String address;

    private LocalDateTime additionDate;
}
