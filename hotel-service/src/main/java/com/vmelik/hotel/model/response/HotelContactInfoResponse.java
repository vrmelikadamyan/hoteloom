package com.vmelik.hotel.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelContactInfoResponse {

    private UUID hotelId;

    private String contactType;

    private String value;
}
