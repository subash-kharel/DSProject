package com.cart.cartItem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long catalogItemId;

    @Column
    private int stockQuantity;

    @Column
    private String description;
}
