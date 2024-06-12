package com.vmelik.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    public RestClient hotelServiceRestClient(@Value("${services.hotel-service.url}") String hotelServiceUrl) {
        return RestClient
                .builder()
                .baseUrl(hotelServiceUrl)
                .requestInterceptor(requestInterceptor())
                .build();
    }

    private ClientHttpRequestInterceptor requestInterceptor() {
        return (request, body, execution) -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
                request
                        .getHeaders()
                        .set(
                                "Authorization", "Bearer " + ((Jwt) authentication.getPrincipal()).getTokenValue());
            }
            return execution.execute(request, body);
        };
    }
}
