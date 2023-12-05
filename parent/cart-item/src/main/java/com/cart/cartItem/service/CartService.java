package com.cart.cartItem.service;

//import com.cart.cartItem.client.CatalogRestTemplateClient;
import com.cart.cartItem.client.CatalogServiceClient;
import com.cart.cartItem.dto.CartItemDTO;
import com.cart.cartItem.model.CartItem;
import com.cart.cartItem.repository.CartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CatalogServiceClient catalogServiceClient;

    @Autowired
//    private CatalogRestTemplateClient catalogRestTemplateClient;
    private CatalogServiceClient catalogRestTemplateClient;

    public List<CartItem> getAllItemsInCart() {
        return cartRepository.findAll();
    }

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

//    @CircuitBreaker(name = "cartService", fallbackMethod = "buildFallbackLicenseList")
    public CartItem addToCart(int cartItemId) throws TimeoutException {
        randomlyRunLong();
//        CartItemDTO cartItemDTO = catalogServiceClient.getCatalogItemById(cartItemId);
        CartItemDTO cartItemDTO = catalogRestTemplateClient.getCatalogItemById(cartItemId);
        CartItem  cartItem = new CartItem();
        cartItem.setCatalogItemId(cartItemDTO.getId());
        cartItem.setDescription(cartItemDTO.getDescription());
        cartItem.setStockQuantity(cartItemDTO.getStockQuantity());
        cartRepository.save(cartItem);
        return cartItem;
    }
    @SuppressWarnings("unused")
    private List<CartItem> buildFallbackLicenseList(Throwable t){
        List<CartItem> fallbackList = new ArrayList<>();
        CartItem cartItem = new CartItem();
        cartItem.setDescription("CartItem not found");
        fallbackList.add(cartItem);
        return fallbackList;
    }

    public CartItem updateCart(CartItem cartItem) {
        Long cartItemId = cartItem.getId();
        if(cartRepository.existsById(cartItemId)){
            cartItem.setId(cartItemId);
        }
        return cartRepository.save(cartItem);
    }

    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
