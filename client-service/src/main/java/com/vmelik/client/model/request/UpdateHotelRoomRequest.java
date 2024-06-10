package com.vmelik.client.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHotelRoomRequest {

    private short roomNumber;

    private String description;

    private short roomTypeId;
}
