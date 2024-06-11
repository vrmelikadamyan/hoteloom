package com.vmelik.client.controller;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelContactRequest;
import com.vmelik.client.model.request.UpdateHotelContactRequest;
import com.vmelik.client.model.response.HotelContactInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client/hotels/contacts")
@RequiredArgsConstructor
public class HotelContactController {
    private final HotelServiceClient hotelServiceClient;

    @PostMapping
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelContactInfoResponse addContact(
            @RequestBody @Valid AddHotelContactRequest addHotelContactRequest
    ) {
        return hotelServiceClient.addContact(addHotelContactRequest);
    }

    @GetMapping("/{contactId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelContactInfoResponse findContact(
            @PathVariable("contactId") UUID contactId
    ) {
        return hotelServiceClient.findContact(contactId);
    }

    @PutMapping("/{contactId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelContactInfoResponse updateContact(
            @PathVariable("contactId") UUID contactId,
            @RequestBody @Valid UpdateHotelContactRequest updateHotelContactRequest
    ) {
        return hotelServiceClient.updateContact(contactId, updateHotelContactRequest);
    }

    @DeleteMapping("/{contactId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelContactInfoResponse deleteContact(
            @PathVariable("contactId") UUID contactId
    ) {
        return hotelServiceClient.deleteContact(contactId);
    }
}
