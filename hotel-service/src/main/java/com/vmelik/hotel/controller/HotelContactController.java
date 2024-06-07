package com.vmelik.hotel.controller;

import com.vmelik.hotel.model.entity.HotelContact;
import com.vmelik.hotel.model.request.AddHotelContactRequest;
import com.vmelik.hotel.model.request.UpdateHotelContactRequest;
import com.vmelik.hotel.model.response.HotelContactInfoResponse;
import com.vmelik.hotel.service.HotelContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/hotels/{hotelId}/contacts")
@RequiredArgsConstructor
public class HotelContactController {
    private final HotelContactService hotelContactService;

    @PostMapping
    public HotelContactInfoResponse addContact(
            @PathVariable("hotelId") UUID hotelId,
            @RequestBody @Valid AddHotelContactRequest addHotelContactRequest
    ) {
        HotelContact hotelContact = hotelContactService.addContact(hotelId, addHotelContactRequest);

        return new HotelContactInfoResponse(
                hotelContact.getId(),
                hotelContact.getContactType().getName(),
                hotelContact.getValue()
        );
    }

    @GetMapping
    public HotelContactInfoResponse findContact(
            @PathVariable("contactId") UUID contactId
    ) {
        HotelContact hotelContact = hotelContactService.findContact(contactId);

        return new HotelContactInfoResponse(
                hotelContact.getId(),
                hotelContact.getContactType().getName(),
                hotelContact.getValue()
        );
    }

    @PutMapping
    public HotelContactInfoResponse updateContact(
            @PathVariable("contactId") UUID contactId,
            @RequestBody @Valid UpdateHotelContactRequest updateHotelContactRequest
    ) {
        HotelContact hotelContact = hotelContactService.updateContact(contactId, updateHotelContactRequest);

        return new HotelContactInfoResponse(
                hotelContact.getId(),
                hotelContact.getContactType().getName(),
                hotelContact.getValue()
        );
    }

    @DeleteMapping
    public HotelContactInfoResponse deleteContact(
            @PathVariable("contactId") UUID contactId
    ) {
        HotelContact hotelContact = hotelContactService.deleteContact(contactId);

        return new HotelContactInfoResponse(
                hotelContact.getId(),
                hotelContact.getContactType().getName(),
                hotelContact.getValue()
        );
    }
}
