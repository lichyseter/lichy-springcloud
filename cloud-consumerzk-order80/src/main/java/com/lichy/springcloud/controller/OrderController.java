package com.lichy.springcloud.controller;

import com.lichy.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://cloud-payment-srvice";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public CommonResult getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/consumer/zk", CommonResult.class);
    }
}
