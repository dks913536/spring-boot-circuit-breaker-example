package com.orderdemo.service;

import com.orderdemo.client.PaymentClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PaymentClient paymentClient;

    @CircuitBreaker(name = "payment-demo",fallbackMethod = "fallbackMethod")
    public String placeOrder(){
        return paymentClient.makePayment();
    }

    public String fallbackMethod(Throwable ex){
        System.out.println("CIRCUIT BREAKER FALLBACK CALLED!");
        System.out.println("Exception: " + ex.getClass().getName());
        System.out.println("Message: " + ex.getMessage());
        return "Payment service is temporarily unavailable. Please try later.";
    }
}
