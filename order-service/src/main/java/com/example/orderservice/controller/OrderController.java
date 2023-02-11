package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory" , fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        String s = orderService.placeOrder(orderRequest);
        return s;
        /*String ret = "";
        if (x >= 0){
            ret = "Your order was placed successfully. The total price of your order is: "+ x +"$";
        }
        else {
            ret = "Your order cannot be placed because not all items exist with the required quantity.";
        }
        return ret;*/
    }
    public String fallbackMethod(OrderRequest orderRequest,Exception e){
        System.out.println("BKHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        return "Something went wrong, please try again later!";
    }
    @GetMapping
    public String p(){
        return "Hello";
    }
}
