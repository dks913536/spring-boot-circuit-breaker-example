package com.orderdemo.controller;

import com.orderdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // http://localhost:8080/create
    @PostMapping("/create")
    public String createOrder(){
        String details=orderService.placeOrder();
        return details;
    }
}
