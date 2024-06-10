package com.vmelik.client.controller;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelContactRequest;
import com.vmelik.client.model.request.UpdateHotelContactRequest;
import com.vmelik.client.model.response.HotelContactInfoResponse;
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
    public HotelContactInfoResponse addContact(
            @RequestBody @Valid AddHotelContactRequest addHotelContactRequest
    ) {
        return hotelServiceClient.addContact(addHotelContactRequest);
    }

    @GetMapping("/{contactId}")
    public HotelContactInfoResponse findContact(
            @PathVariable("contactId") UUID contactId
    ) {
        return hotelServiceClient.findContact(contactId);
    }

    @PutMapping("/{contactId}")
    public HotelContactInfoResponse updateContact(
            @PathVariable("contactId") UUID contactId,
            @RequestBody @Valid UpdateHotelContactRequest updateHotelContactRequest
    ) {
        return hotelServiceClient.updateContact(contactId, updateHotelContactRequest);
    }

    @DeleteMapping("/{contactId}")
    public HotelContactInfoResponse deleteContact(
            @PathVariable("contactId") UUID contactId
    ) {
        return hotelServiceClient.deleteContact(contactId);
    }
}
