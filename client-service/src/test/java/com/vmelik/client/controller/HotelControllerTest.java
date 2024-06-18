//package com.vmelik.client.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.vmelik.client.client.HotelServiceClient;
//import com.vmelik.client.model.request.AddHotelRequest;
//import com.vmelik.client.model.request.UpdateHotelRequest;
//import com.vmelik.client.model.response.HotelInfoResponse;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(HotelController.class)
//class HotelControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private HotelServiceClient hotelServiceClient;
//
//    @Test
//    void addHotel() throws Exception {
//        // given
//        AddHotelRequest request = new AddHotelRequest(
//                "hotel",
//                (short) 3,
//                "description",
//                "address"
//        );
//
//        HotelInfoResponse createdHotel = new HotelInfoResponse(
//                UUID.randomUUID(),
//                "hotel",
//                (short) 3,
//                "description",
//                "address",
//                LocalDateTime.now()
//        );
//
//        when(hotelServiceClient.addHotel(request)).thenReturn(createdHotel);
//        mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .post("/client/hotels")
//                                .content(toJsonString(request))
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(toJsonString(createdHotel)));
//    }
//
//    @Test
//    void updateHotel() throws Exception {
//        // given
//        UpdateHotelRequest request = new UpdateHotelRequest(
//                "hotel",
//                (short) 3,
//                "description NEW",
//                "address NEW"
//        );
//
//        UUID hotelId = UUID.randomUUID();
//        HotelInfoResponse existingHotel = new HotelInfoResponse(
//                hotelId,
//                "hotel",
//                (short) 3,
//                "description",
//                "address",
//                LocalDateTime.now()
//        );
//
//        HotelInfoResponse updatedHotel = new HotelInfoResponse(
//                hotelId,
//                "hotel",
//                (short) 3,
//                "description NEW",
//                "address NEW",
//                existingHotel.getAdditionDate()
//        );
//
//        when(hotelServiceClient.updateHotel(hotelId, request)).thenReturn(updatedHotel);
//        mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .put("/client/hotels/{hotelId}", hotelId)
//                                .content(toJsonString(request))
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(toJsonString(updatedHotel)));
//    }
//
//    @Test
//    void findHotelById() throws Exception {
//        // given
//        UUID hotelId = UUID.randomUUID();
//        HotelInfoResponse existingHotel = new HotelInfoResponse(
//                hotelId,
//                "hotel",
//                (short) 3,
//                "description",
//                "address",
//                LocalDateTime.now()
//        );
//
//        when(hotelServiceClient.findHotelById(hotelId)).thenReturn(existingHotel);
//        mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/client/hotels/{hotelId}", hotelId)
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(toJsonString(existingHotel)));
//    }
//
//    @Test
//    void deleteHotel() throws Exception {
//        // given
//        UUID hotelId = UUID.randomUUID();
//        HotelInfoResponse existingHotel = new HotelInfoResponse(
//                hotelId,
//                "hotel",
//                (short) 3,
//                "description",
//                "address",
//                LocalDateTime.now()
//        );
//
//        when(hotelServiceClient.deleteHotel(hotelId)).thenReturn(existingHotel);
//        mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .delete("/client/hotels/{hotelId}", hotelId)
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(toJsonString(existingHotel)));
//    }
//
//    private String toJsonString(Object o) {
//        try {
//            return objectMapper.writeValueAsString(o);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}