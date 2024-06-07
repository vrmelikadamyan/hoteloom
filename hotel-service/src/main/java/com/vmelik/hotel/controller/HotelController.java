package com.vmelik.hotel.controller;

import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.request.AddHotelRequest;
import com.vmelik.hotel.model.request.UpdateHotelRequest;
import com.vmelik.hotel.model.response.HotelInfoResponse;
import com.vmelik.hotel.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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
