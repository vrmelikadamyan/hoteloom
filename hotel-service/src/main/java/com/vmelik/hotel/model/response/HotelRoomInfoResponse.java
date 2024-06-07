package com.vmelik.hotel.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRoomInfoResponse {

    private UUID id;

    private UUID hotelId;

    private short roomNumber;

    private String description;

    private HotelRoomTypeResponse roomType;
}
