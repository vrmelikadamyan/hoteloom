package com.vmelik.hotel.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHotelRoomRequest {

    private UUID hotelId;

    private short roomNumber;

    private String description;

    private short roomTypeId;
}
