package com.processing.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int stockQuantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Orders order;


    // Getters and setters
}