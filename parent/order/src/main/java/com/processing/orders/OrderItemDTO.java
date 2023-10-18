package com.processing.orders;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;
    private Long cartId;
    private int stockQuantity;
    private double price;
}
