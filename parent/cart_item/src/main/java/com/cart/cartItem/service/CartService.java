package com.cart.cartItem.service;

import com.cart.cartItem.client.CatalogServiceClient;
import com.cart.cartItem.dto.CartItemDTO;
import com.cart.cartItem.model.CartItem;
import com.cart.cartItem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public CartItem addToCart(int cartItemId) {
        CartItemDTO cartItemDTO = catalogServiceClient.getCatalogItemById(cartItemId);
        CartItem  cartItem = new CartItem();
        cartItem.setCatalogItemId(cartItemDTO.getId());
        cartItem.setDescription(cartItemDTO.getDescription());
        cartItem.setStockQuantity(cartItemDTO.getStockQuantity());
        cartRepository.save(cartItem);
        return cartItem;
    }

    public CartItem updateCart(CartItem cartItem) {
        Long cartItemId = cartItem.getId();
        if(cartRepository.existsById(cartItemId)){
            cartItem.setId(cartItemId);
        }
        return cartRepository.save(cartItem);
    }
}
