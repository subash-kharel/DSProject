package com.cart.cartItem.client;

import com.cart.cartItem.dto.CartItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "catalog-service", url = "${catalog.service.url}")
public interface CatalogServiceClient {

    @GetMapping("/v1/catalog/{id}")
    CartItemDTO getCatalogItemById(@PathVariable int id);
}
