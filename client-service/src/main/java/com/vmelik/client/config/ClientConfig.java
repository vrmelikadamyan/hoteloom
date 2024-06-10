package com.vmelik.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    public RestClient hotelServiceRestClient(@Value("${services.hotel-service.url}") String hotelServiceUrl) {
        return RestClient.create(hotelServiceUrl);
    }
}
