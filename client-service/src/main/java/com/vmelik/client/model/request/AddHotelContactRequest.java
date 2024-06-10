package com.vmelik.client.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHotelContactRequest {

    @NotBlank
    private UUID hotelId;

    @NotBlank
    private String contactType;

    @NotBlank
    private String value;
}
