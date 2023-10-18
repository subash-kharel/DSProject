package com.cart.cartItem.controller;

import com.cart.cartItem.dto.CartItemDTO;
import com.cart.cartItem.model.CartItem;
import com.cart.cartItem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartItem> getAllItemsInCart(){
        return cartService.getAllItemsInCart();
    }

    @PostMapping(("/{id}"))
    public CartItem addToCart(@PathVariable int id){

        return cartService.addToCart(id);
    }

    @PutMapping(("/{id}"))
    public CartItem updateCart(@RequestBody CartItem cartItem){

        return cartService.updateCart(cartItem );
    }
}
