package com.cart.cartItem.controller;

import com.cart.cartItem.dto.CartItemDTO;
import com.cart.cartItem.model.CartItem;
import com.cart.cartItem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value ="v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @RolesAllowed({ "ADMIN", "USER" })
    public List<CartItem> getAllItemsInCart(){
        return cartService.getAllItemsInCart();
    }

    @PostMapping(("/{id}"))
    @RolesAllowed({ "ADMIN", "USER" })
    public CartItem addToCart(@PathVariable int id) throws TimeoutException {

        return cartService.addToCart(id);
    }

    @PutMapping(("/{id}"))
    @RolesAllowed({ "ADMIN", "USER" })
    public CartItem updateCart(@RequestBody CartItem cartItem){

        return cartService.updateCart(cartItem );
    }
}
