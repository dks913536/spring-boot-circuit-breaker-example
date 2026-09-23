package com.paymentdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PaymentController {

    @GetMapping("/payment/pay")
    public String processPayment(){
        if(new Random().nextInt(10) <7){
            throw  new RuntimeException("PaymentController service down!");
        }
        return "Payment Successful";
    }
}
