package com.vmelik.client.controller;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelRequest;
import com.vmelik.client.model.request.UpdateHotelRequest;
import com.vmelik.client.model.response.HotelInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelServiceClient hotelServiceClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelInfoResponse addHotel(@RequestBody @Valid AddHotelRequest hotel) {
        return hotelServiceClient.addHotel(hotel);
    }

    @PutMapping("/{hotelId}")
    public HotelInfoResponse updateHotel(
            @PathVariable("hotelId") UUID hotelId,
            @RequestBody @Valid UpdateHotelRequest hotel) {
        return hotelServiceClient.updateHotel(hotelId, hotel);
    }

    @GetMapping("/{hotelId}")
    public HotelInfoResponse findHotelById(@PathVariable("hotelId") UUID hotelId) {
        return hotelServiceClient.findHotelById(hotelId);
    }

    @DeleteMapping("/{hotelId}")
    public HotelInfoResponse deleteHotel(@PathVariable("hotelId") UUID hotelId) {
        return hotelServiceClient.deleteHotel(hotelId);
    }
}
