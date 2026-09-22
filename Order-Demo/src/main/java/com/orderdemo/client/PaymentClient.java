package com.orderdemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PAYMENT-DEMO",url = "http://localhost:8081")
public interface PaymentClient {

    @GetMapping("payment/pay")
    String makePayment();

}
