package com.vmelik.client.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHotelContactRequest {

    @NotBlank
    private String contactType;

    @NotBlank
    private String value;
}
