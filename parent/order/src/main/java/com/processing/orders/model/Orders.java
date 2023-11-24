package com.processing.orders.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int userId;
    @Column
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
    @Column
    private double totalCost;
}
