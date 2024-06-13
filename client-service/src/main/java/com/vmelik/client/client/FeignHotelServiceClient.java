package com.vmelik.client.client;

import com.vmelik.client.model.request.*;
import com.vmelik.client.model.response.HotelContactInfoResponse;
import com.vmelik.client.model.response.HotelInfoResponse;
import com.vmelik.client.model.response.HotelRoomInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient("hotel-service")
public interface FeignHotelServiceClient extends HotelServiceClient {

    @Override
    @PostMapping("/api/hotels")
    HotelInfoResponse addHotel(@RequestBody AddHotelRequest hotel);

    @Override
    @PutMapping("/api/hotels/{hotelId}")
    HotelInfoResponse updateHotel(@PathVariable("hotelId") UUID hotelId, @RequestBody UpdateHotelRequest hotel);

    @Override
    @GetMapping("/api/hotels/{hotelId}")
    HotelInfoResponse findHotelById(@PathVariable("hotelId") UUID hotelId);

    @Override
    @DeleteMapping("/api/hotels/{hotelId}")
    HotelInfoResponse deleteHotel(@PathVariable("hotelId") UUID hotelId);

    @Override
    @PostMapping("api/hotels/contacts")
    HotelContactInfoResponse addContact(@RequestBody AddHotelContactRequest addHotelContactRequest);

    @Override
    @GetMapping("api/hotels/contacts/{contactId}")
    HotelContactInfoResponse findContact(@PathVariable("contactId") UUID contactId);

    @Override
    @PutMapping("api/hotels/contacts/{contactId}")
    HotelContactInfoResponse updateContact(@PathVariable("contactId") UUID contactId, @RequestBody UpdateHotelContactRequest updateHotelContactRequest);

    @Override
    @DeleteMapping("api/hotels/contacts/{contactId}")
    HotelContactInfoResponse deleteContact(@PathVariable("contactId") UUID contactId);

    @Override
    @PostMapping("api/hotels/rooms")
    HotelRoomInfoResponse addHotelRoom(@RequestBody AddHotelRoomRequest request);

    @Override
    @GetMapping("api/hotels/rooms/{roomId}")
    HotelRoomInfoResponse findHotelRoom(@PathVariable("roomId") UUID roomId);

    @Override
    @PutMapping("api/hotels/rooms/{roomId}")
    HotelRoomInfoResponse updateHotelRoom(@PathVariable("roomId") UUID roomId, @RequestBody UpdateHotelRoomRequest request);

    @Override
    @DeleteMapping("api/hotels/rooms/{roomId}")
    HotelRoomInfoResponse deleteHotelRoom(@PathVariable("roomId") UUID roomId);
}
