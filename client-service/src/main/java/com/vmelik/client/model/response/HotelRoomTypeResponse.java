package com.vmelik.client.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRoomTypeResponse {

    private short id;

    private String name;

    private String description;

    private Integer cost;
}
