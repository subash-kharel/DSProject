package com.processing.orders.client;

import com.processing.orders.OrderItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "cart-item", url = "${cart.service.url}")
public interface CartServiceClient {
    @GetMapping("/v1/cart")
    List<OrderItemDTO> getAllItemsInCart();
}



