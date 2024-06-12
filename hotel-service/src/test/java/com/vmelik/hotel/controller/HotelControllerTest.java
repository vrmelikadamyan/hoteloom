package com.vmelik.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.request.AddHotelRequest;
import com.vmelik.hotel.model.request.UpdateHotelRequest;
import com.vmelik.hotel.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HotelController.class)
class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HotelService hotelService;

    @Test
    void addHotel() throws Exception {
        // given
        AddHotelRequest request = new AddHotelRequest(
                "hotel",
                (short) 3,
                "description",
                "address"
        );

        Hotel createdHotel = new Hotel(
                UUID.randomUUID(),
                "hotel",
                (short) 3,
                "description",
                "address",
                LocalDateTime.now()
        );

        when(hotelService.addHotel(request)).thenReturn(createdHotel);
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/hotels")
                                .content(toJsonString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(toJsonString(createdHotel)));
    }

    @Test
    void updateHotel() throws Exception {
        // given
        UpdateHotelRequest request = new UpdateHotelRequest(
                "hotel",
                (short) 3,
                "description NEW",
                "address NEW"
        );

        UUID hotelId = UUID.randomUUID();
        Hotel existingHotel = new Hotel(
                hotelId,
                "hotel",
                (short) 3,
                "description",
                "address",
                LocalDateTime.now()
        );

        Hotel updatedHotel = new Hotel(
                hotelId,
                "hotel",
                (short) 3,
                "description NEW",
                "address NEW",
                existingHotel.getAdditionDate()
        );

        when(hotelService.updateHotel(hotelId, request)).thenReturn(updatedHotel);
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/hotels/{hotelId}", hotelId)
                                .content(toJsonString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(toJsonString(updatedHotel)));
    }

    @Test
    void findHotelById() throws Exception {
        // given
        UUID hotelId = UUID.randomUUID();
        Hotel existingHotel = new Hotel(
                hotelId,
                "hotel",
                (short) 3,
                "description",
                "address",
                LocalDateTime.now()
        );

        when(hotelService.findHotel(hotelId)).thenReturn(existingHotel);
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/hotels/{hotelId}", hotelId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(toJsonString(existingHotel)));
    }

    @Test
    void deleteHotel() throws Exception {
        // given
        UUID hotelId = UUID.randomUUID();
        Hotel existingHotel = new Hotel(
                hotelId,
                "hotel",
                (short) 3,
                "description",
                "address",
                LocalDateTime.now()
        );

        when(hotelService.deleteHotel(hotelId)).thenReturn(existingHotel);
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/hotels/{hotelId}", hotelId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(toJsonString(existingHotel)));
    }

    private String toJsonString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}