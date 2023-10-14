package com.product.catalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Catalog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private int stockQuantity;
}
