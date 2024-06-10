package com.vmelik.client.controller;

import com.vmelik.client.model.request.AddHotelContactRequest;
import com.vmelik.client.model.request.UpdateHotelContactRequest;
import com.vmelik.client.model.response.HotelContactInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client/hotels/{hotelId}/contacts")
@RequiredArgsConstructor
public class HotelContactController {

    @PostMapping
    public HotelContactInfoResponse addContact(
            @PathVariable("hotelId") UUID hotelId,
            @RequestBody @Valid AddHotelContactRequest addHotelContactRequest
    ) {
        return null;
    }

    @GetMapping
    public HotelContactInfoResponse findContact(
            @PathVariable("contactId") UUID contactId
    ) {
        return null;
    }

    @PutMapping
    public HotelContactInfoResponse updateContact(
            @PathVariable("contactId") UUID contactId,
            @RequestBody @Valid UpdateHotelContactRequest updateHotelContactRequest
    ) {
        return null;
    }

    @DeleteMapping
    public HotelContactInfoResponse deleteContact(
            @PathVariable("contactId") UUID contactId
    ) {
        return null;
    }
}
