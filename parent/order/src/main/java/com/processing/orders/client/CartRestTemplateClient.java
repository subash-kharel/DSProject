package com.processing.orders.client;

import com.processing.orders.OrderItemDTO;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartRestTemplateClient {

    @Autowired
    private KeycloakRestTemplate restTemplate;

    public List<OrderItemDTO> getAllItemsInCart(){
        ResponseEntity<List<OrderItemDTO>> restExchange =
                restTemplate.exchange(
                        "http://gateway:8075/cart-item/v1/cart",
                        HttpMethod.GET,
                        null, new ParameterizedTypeReference<>() {
                        });
        return restExchange.getBody();
    }

}