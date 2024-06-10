package com.vmelik.client.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHotelRequest {

    @NotBlank
    private String name;

    @Min(1)
    @Max(5)
    private short starRating;

    private String description;

    @NotBlank
    private String address;
}
