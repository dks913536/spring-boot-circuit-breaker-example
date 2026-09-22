package com.orderdemo.service;

import com.orderdemo.client.PaymentClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PaymentClient paymentClient;

    @CircuitBreaker(name = "Payment-Demo",fallbackMethod = "fallbackMethod")
    public String placeOrder(){
        return paymentClient.makePayment();
    }

    public String fallbackMethod(Exception e){
        return "Payment service is temporarily unavailable. Please try later.";
    }
}
