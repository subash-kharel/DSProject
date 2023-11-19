package com.processing.orders.service;

import com.processing.orders.OrderItemDTO;
import com.processing.orders.client.CartServiceClient;
import com.processing.orders.model.OrderItem;
import com.processing.orders.model.Orders;
import com.processing.orders.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartServiceClient cartServiceClient;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @CircuitBreaker(name = "orderService", fallbackMethod = "buildFallbackLicenseList")
    public Orders createOrder(Orders catalog) throws Exception {
        List<OrderItemDTO> orderItemDTO = cartServiceClient.getAllItemsInCart();
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemDTO.forEach(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(item.getPrice());
            orderItem.setStockQuantity(item.getStockQuantity());
            orderItem.setProductId(item.getId());
            orderItemList.add(orderItem);
        });
        catalog.setOrderItems(orderItemList);
        return orderRepository.save(catalog);
    }

    private List<Orders> buildFallbackLicenseList(String organizationId, Throwable t){
        List<Orders> fallbackList = new ArrayList<>();
        Orders orders = new Orders();
        orders.setName("Orders not found for organizationId: "+ organizationId);
        fallbackList.add(orders);
        return fallbackList;
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
