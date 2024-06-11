package com.vmelik.client.client.impl;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.*;
import com.vmelik.client.model.response.HotelContactInfoResponse;
import com.vmelik.client.model.response.HotelInfoResponse;
import com.vmelik.client.model.response.HotelRoomInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HotelServiceClientImpl implements HotelServiceClient {
    private final RestClient hotelServiceRestClient;

    @Override
    public HotelInfoResponse addHotel(AddHotelRequest hotel) {
        return hotelServiceRestClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(hotel)
                .retrieve()
                .body(HotelInfoResponse.class);
    }

    @Override
    public HotelInfoResponse updateHotel(UUID hotelId, UpdateHotelRequest hotel) {
        return hotelServiceRestClient
                .put()
                .uri("/{hotelId}", hotelId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(hotel)
                .retrieve()
                .body(HotelInfoResponse.class);
    }

    @Override
    public HotelInfoResponse findHotelById(UUID hotelId) {
        return hotelServiceRestClient
                .get()
                .uri("/{hotelId}", hotelId)
                .retrieve()
                .body(HotelInfoResponse.class);
    }

    @Override
    public HotelInfoResponse deleteHotel(UUID hotelId) {
        return hotelServiceRestClient
                .delete()
                .uri("/{hotelId}", hotelId)
                .retrieve()
                .body(HotelInfoResponse.class);
    }

    @Override
    public HotelContactInfoResponse addContact(AddHotelContactRequest contact) {
        return hotelServiceRestClient
                .post()
                .uri("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(contact)
                .retrieve()
                .body(HotelContactInfoResponse.class);
    }

    @Override
    public HotelContactInfoResponse findContact(UUID contactId) {
        return hotelServiceRestClient
                .get()
                .uri("/contacts/{contactId}", contactId)
                .retrieve()
                .body(HotelContactInfoResponse.class);
    }

    @Override
    public HotelContactInfoResponse updateContact(UUID contactId, UpdateHotelContactRequest contact) {
        return hotelServiceRestClient
                .put()
                .uri("/contacts/{contactId}", contactId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(contact)
                .retrieve()
                .body(HotelContactInfoResponse.class);
    }

    @Override
    public HotelContactInfoResponse deleteContact(UUID contactId) {
        return hotelServiceRestClient
                .delete()
                .uri("/contacts/{contactId}", contactId)
                .retrieve()
                .body(HotelContactInfoResponse.class);
    }

    @Override
    public HotelRoomInfoResponse addHotelRoom(AddHotelRoomRequest request) {
        return hotelServiceRestClient
                .post()
                .uri("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(HotelRoomInfoResponse.class);
    }

    @Override
    public HotelRoomInfoResponse findHotelRoom(UUID roomId) {
        return hotelServiceRestClient
                .get()
                .uri("/rooms/{roomId}", roomId)
                .retrieve()
                .body(HotelRoomInfoResponse.class);
    }

    @Override
    public HotelRoomInfoResponse updateHotelRoom(UUID roomId, UpdateHotelRoomRequest request) {
        return hotelServiceRestClient
                .put()
                .uri("/rooms/{roomId}", roomId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(HotelRoomInfoResponse.class);
    }

    @Override
    public HotelRoomInfoResponse deleteHotelRoom(UUID roomId) {
        return hotelServiceRestClient
                .delete()
                .uri("/rooms/{roomId}", roomId)
                .retrieve()
                .body(HotelRoomInfoResponse.class);
    }
}
