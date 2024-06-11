package com.vmelik.client.controller;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelRoomRequest;
import com.vmelik.client.model.request.UpdateHotelRoomRequest;
import com.vmelik.client.model.response.HotelRoomInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse addHotelRoom(
            @RequestBody @Valid AddHotelRoomRequest request
    ) {
        return null;
    }

    @GetMapping("/{roomId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse findHotelRoom(@PathVariable("roomId") UUID roomId) {
        return null;
    }

    @PutMapping("/{roomId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse updateHotelRoom(
            @PathVariable("roomId") UUID roomId,
            @RequestBody @Valid UpdateHotelRoomRequest request
    ) {
        return null;
    }

    @DeleteMapping("/{roomId}")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse deleteHotelRoom(@PathVariable("roomId") UUID roomId) {
        return null;
    }
}
