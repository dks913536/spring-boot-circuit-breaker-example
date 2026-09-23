package com.orderdemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Payment-Demo")
public interface PaymentClient {

    @GetMapping("payment/pay")
    String makePayment();

}
