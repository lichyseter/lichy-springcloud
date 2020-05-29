package com.lichy.springcloud.controller;

import com.lichy.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/zk")
    public CommonResult discovery() {
        return new CommonResult(200, "zookeeper" + serverPort,  null);
    }
}
