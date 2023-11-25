package com.processing.orders.controller;

import com.processing.orders.model.Orders;
import com.processing.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value="/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    @RolesAllowed({ "ADMIN", "USER" })
    public Orders createOrder(@RequestBody Orders order) throws Exception {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable int id, @RequestBody Orders updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
