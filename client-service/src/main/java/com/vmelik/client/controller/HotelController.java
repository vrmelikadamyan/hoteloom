package com.vmelik.client.controller;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelInfoResponse addHotel(@RequestBody @Valid AddHotelRequest hotel) {
        return null;
    }

    @PutMapping("/{hotelId}")
    public HotelInfoResponse updateHotel(
            @PathVariable("hotelId") UUID hotelId,
            @RequestBody @Valid UpdateHotelRequest hotel) {
        return null;
    }

    @GetMapping("/{hotelId}")
    public HotelInfoResponse findHotelById(@PathVariable("hotelId") UUID hotelId) {
        return null;
    }

    @DeleteMapping("/{hotelId}")
    public HotelInfoResponse deleteHotel(@PathVariable("hotelId") UUID hotelId) {
        return null;
    }
}
