package com.vmelik.hotel.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHotelContactRequest {

    @NotBlank
    private String contactType;

    @NotBlank
    private String value;
}
