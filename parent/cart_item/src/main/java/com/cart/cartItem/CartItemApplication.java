package com.cart.cartItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CartItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartItemApplication.class, args);
	}

}
