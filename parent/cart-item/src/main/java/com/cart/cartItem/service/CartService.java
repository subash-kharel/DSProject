package com.cart.cartItem.service;

import com.cart.cartItem.client.CatalogServiceClient;
import com.cart.cartItem.dto.CartItemDTO;
import com.cart.cartItem.model.CartItem;
import com.cart.cartItem.repository.CartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CatalogServiceClient catalogServiceClient;

    public List<CartItem> getAllItemsInCart() {
        return cartRepository.findAll();
    }

    @CircuitBreaker(name = "cartService", fallbackMethod = "buildFallbackLicenseList")
    public CartItem addToCart(int cartItemId) {
        CartItemDTO cartItemDTO = catalogServiceClient.getCatalogItemById(cartItemId);
        CartItem  cartItem = new CartItem();
        cartItem.setCatalogItemId(cartItemDTO.getId());
        cartItem.setDescription(cartItemDTO.getDescription());
        cartItem.setStockQuantity(cartItemDTO.getStockQuantity());
        cartRepository.save(cartItem);
        return cartItem;
    }
    private List<CartItem> buildFallbackLicenseList(String organizationId, Throwable t){
        List<CartItem> fallbackList = new ArrayList<>();
        CartItem cartItem = new CartItem();
        cartItem.setDescription("CartItem not found for organizationId " + organizationId);
        fallbackList.add(cartItem);
        return fallbackList;
    }

    public CartItem updateCart(CartItem cartItem) {
        Long cartItemId = cartItem.getId();
        if(cartRepository.existsById(cartItemId)){
            cartItem.setId(cartItemId);
        }
        return cartRepository.save(cartItem);
    }
}
