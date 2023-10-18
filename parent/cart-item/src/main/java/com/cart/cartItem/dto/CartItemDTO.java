package com.cart.cartItem.dto;


import lombok.Data;

@Data
public class CartItemDTO {
    private Long id;
    private int stockQuantity;
    private String description;
}
