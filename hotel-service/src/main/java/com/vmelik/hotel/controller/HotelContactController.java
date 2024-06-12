package com.vmelik.hotel.controller;

import com.vmelik.hotel.model.entity.HotelContact;
import com.vmelik.hotel.model.request.AddHotelContactRequest;
import com.vmelik.hotel.model.request.UpdateHotelContactRequest;
import com.vmelik.hotel.model.response.HotelContactInfoResponse;
import com.vmelik.hotel.service.HotelContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/hotels/contacts")
@RequiredArgsConstructor
public class HotelContactController {
    private final HotelContactService hotelContactService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelContactInfoResponse addContact(
            @RequestBody @Valid AddHotelContactRequest addHotelContactRequest
    ) {
        HotelContact hotelContact = hotelContactService.addContact(addHotelContactRequest);

        return new HotelContactInfoResponse(
                hotelContact.getId(),
                hotelContact.getContactType().getName(),
                hotelContact.getValue()
        );
    }

    @GetMapping("/{contactId}")
    @PreAuthorize("hasRole('user')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
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

    @PutMapping("/{contactId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
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

    @DeleteMapping("/{contactId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
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
