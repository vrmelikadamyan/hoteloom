package com.vmelik.hotel.controller;

import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.request.AddHotelRequest;
import com.vmelik.hotel.model.request.UpdateHotelRequest;
import com.vmelik.hotel.model.response.HotelInfoResponse;
import com.vmelik.hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelInfoResponse addHotel(@RequestBody @Valid AddHotelRequest hotel) {
        Hotel newHotel = hotelService.addHotel(hotel);

        return new HotelInfoResponse(
                newHotel.getId(),
                newHotel.getName(),
                newHotel.getStarRating(),
                newHotel.getDescription(),
                newHotel.getAddress(),
                newHotel.getAdditionDate()
        );
    }

    @PutMapping("/{hotelId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelInfoResponse updateHotel(
            @PathVariable("hotelId") UUID hotelId,
            @RequestBody @Valid UpdateHotelRequest hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);

        return new HotelInfoResponse(
                updatedHotel.getId(),
                updatedHotel.getName(),
                updatedHotel.getStarRating(),
                updatedHotel.getDescription(),
                updatedHotel.getAddress(),
                updatedHotel.getAdditionDate()
        );
    }

    @GetMapping("/{hotelId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelInfoResponse findHotelById(@PathVariable("hotelId") UUID hotelId) {
        Hotel foundedHotel = hotelService.findHotel(hotelId);

        return new HotelInfoResponse(
                foundedHotel.getId(),
                foundedHotel.getName(),
                foundedHotel.getStarRating(),
                foundedHotel.getDescription(),
                foundedHotel.getAddress(),
                foundedHotel.getAdditionDate()
        );
    }

    @DeleteMapping("/{hotelId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelInfoResponse deleteHotel(@PathVariable("hotelId") UUID hotelId) {
        Hotel removedHotel = hotelService.deleteHotel(hotelId);

        return new HotelInfoResponse(
                removedHotel.getId(),
                removedHotel.getName(),
                removedHotel.getStarRating(),
                removedHotel.getDescription(),
                removedHotel.getAddress(),
                removedHotel.getAdditionDate()
        );
    }
}
