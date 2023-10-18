package com.processing.orders.controller;

import com.processing.orders.model.OrderItem;
import com.processing.orders.model.Orders;
import com.processing.orders.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="v1/order-item")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }
}
