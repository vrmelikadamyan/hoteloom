package com.vmelik.client.controller;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelRoomRequest;
import com.vmelik.client.model.request.UpdateHotelRoomRequest;
import com.vmelik.client.model.response.HotelRoomInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client/hotels/rooms")
@RequiredArgsConstructor
public class HotelRoomController {
    private final HotelServiceClient hotelServiceClient;

    @PostMapping
    public HotelRoomInfoResponse addHotelRoom(
            @RequestBody @Valid AddHotelRoomRequest request
    ) {
        return null;
    }

    @GetMapping("/{roomId}")
    public HotelRoomInfoResponse findHotelRoom(@PathVariable("roomId") UUID roomId) {
        return null;
    }

    @PutMapping("/{roomId}")
    public HotelRoomInfoResponse updateHotelRoom(
            @PathVariable("roomId") UUID roomId,
            @RequestBody @Valid UpdateHotelRoomRequest request
    ) {
        return null;
    }

    @DeleteMapping("/{roomId}")
    public HotelRoomInfoResponse deleteHotelRoom(@PathVariable("roomId") UUID roomId) {
        return null;
    }
}
