package com.vmelik.hotel.controller;

import com.vmelik.hotel.model.entity.HotelRoom;
import com.vmelik.hotel.model.request.AddHotelRoomRequest;
import com.vmelik.hotel.model.request.UpdateHotelRoomRequest;
import com.vmelik.hotel.model.response.HotelRoomInfoResponse;
import com.vmelik.hotel.model.response.HotelRoomTypeResponse;
import com.vmelik.hotel.service.HotelRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/hotels/rooms")
@RequiredArgsConstructor
public class HotelRoomController {
    private final HotelRoomService hotelRoomService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse addHotelRoom(
            @RequestBody @Valid AddHotelRoomRequest request
    ) {
        HotelRoom hotelRoom = hotelRoomService.addRoom(request);

        return new HotelRoomInfoResponse(
                hotelRoom.getId(),
                hotelRoom.getHotel().getId(),
                hotelRoom.getRoomNumber(),
                hotelRoom.getDescription(),
                new HotelRoomTypeResponse(
                        hotelRoom.getHotelRoomType().getId(),
                        hotelRoom.getHotelRoomType().getName(),
                        hotelRoom.getHotelRoomType().getDescription(),
                        hotelRoom.getHotelRoomType().getCost()
                )
        );
    }

    @GetMapping("/{roomId}")
    @PreAuthorize("hasRole('user')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse findHotelRoom(@PathVariable("roomId") UUID roomId) {
        HotelRoom hotelRoom = hotelRoomService.findRoom(roomId);

        return new HotelRoomInfoResponse(
                hotelRoom.getId(),
                hotelRoom.getHotel().getId(),
                hotelRoom.getRoomNumber(),
                hotelRoom.getDescription(),
                new HotelRoomTypeResponse(
                        hotelRoom.getHotelRoomType().getId(),
                        hotelRoom.getHotelRoomType().getName(),
                        hotelRoom.getHotelRoomType().getDescription(),
                        hotelRoom.getHotelRoomType().getCost()
                )
        );
    }

    @PutMapping("/{roomId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse updateHotelRoom(
            @PathVariable("roomId") UUID roomId,
            @RequestBody @Valid UpdateHotelRoomRequest request
    ) {
        HotelRoom hotelRoom = hotelRoomService.updateRoom(roomId, request);

        return new HotelRoomInfoResponse(
                hotelRoom.getId(),
                hotelRoom.getHotel().getId(),
                hotelRoom.getRoomNumber(),
                hotelRoom.getDescription(),
                new HotelRoomTypeResponse(
                        hotelRoom.getHotelRoomType().getId(),
                        hotelRoom.getHotelRoomType().getName(),
                        hotelRoom.getHotelRoomType().getDescription(),
                        hotelRoom.getHotelRoomType().getCost()
                )
        );
    }

    @DeleteMapping("/{roomId}")
    @PreAuthorize("hasRole('admin')")
    @Operation(security = {@SecurityRequirement(name = "authorization")})
    public HotelRoomInfoResponse deleteHotelRoom(@PathVariable("roomId") UUID roomId) {
        HotelRoom hotelRoom = hotelRoomService.deleteRoom(roomId);

        return new HotelRoomInfoResponse(
                hotelRoom.getId(),
                hotelRoom.getHotel().getId(),
                hotelRoom.getRoomNumber(),
                hotelRoom.getDescription(),
                new HotelRoomTypeResponse(
                        hotelRoom.getHotelRoomType().getId(),
                        hotelRoom.getHotelRoomType().getName(),
                        hotelRoom.getHotelRoomType().getDescription(),
                        hotelRoom.getHotelRoomType().getCost()
                )
        );
    }
}
