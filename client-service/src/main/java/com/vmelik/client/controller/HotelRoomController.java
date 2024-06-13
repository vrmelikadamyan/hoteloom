package com.vmelik.client.controller;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelRoomRequest;
import com.vmelik.client.model.request.UpdateHotelRoomRequest;
import com.vmelik.client.model.response.HotelRoomInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client/hotels/rooms")
@RequiredArgsConstructor
public class HotelRoomController {
    private final HotelServiceClient hotelServiceClient;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse addHotelRoom(
            @RequestBody @Valid AddHotelRoomRequest request
    ) {
        return hotelServiceClient.addHotelRoom(request);
    }

    @GetMapping("/{roomId}")
    @PreAuthorize("hasRole('user')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse findHotelRoom(@PathVariable("roomId") UUID roomId) {
        return hotelServiceClient.findHotelRoom(roomId);
    }

    @PutMapping("/{roomId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse updateHotelRoom(
            @PathVariable("roomId") UUID roomId,
            @RequestBody @Valid UpdateHotelRoomRequest request
    ) {
        return hotelServiceClient.updateHotelRoom(roomId, request);
    }

    @DeleteMapping("/{roomId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse deleteHotelRoom(@PathVariable("roomId") UUID roomId) {
        return hotelServiceClient.deleteHotelRoom(roomId);
    }
}
