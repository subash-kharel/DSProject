package com.cart.cartItem.client;

import com.cart.cartItem.dto.CartItemDTO;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CatalogRestTemplateClient {

    @Autowired
    private KeycloakRestTemplate restTemplate;

    public CartItemDTO getCatalogItemById(int id){
        ResponseEntity<CartItemDTO> restExchange =
                restTemplate.exchange(
                        "http://gateway:8075/catalog/v1/catalog/{id}",
                        HttpMethod.GET,
                        null, CartItemDTO.class, id);

        return restExchange.getBody();
    }
}
