package com.vmelik.client.client.impl;

import com.vmelik.client.client.HotelServiceClient;
import com.vmelik.client.model.request.AddHotelRequest;
import com.vmelik.client.model.request.UpdateHotelRequest;
import com.vmelik.client.model.response.HotelInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HotelServiceRestClient implements HotelServiceClient {
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
}
