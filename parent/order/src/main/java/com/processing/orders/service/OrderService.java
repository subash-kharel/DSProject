package com.processing.orders.service;

import com.processing.orders.model.Orders;
import com.processing.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Orders createOrder(Orders catalog) {
        return orderRepository.save(catalog);
    }

    //todo: create custom messages
    public Orders updateOrder(int id, Orders updatedCatalog) {
        if (orderRepository.existsById(id)) {
            updatedCatalog.setId(id);
            return orderRepository.save(updatedCatalog);
        }
        return null;
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
