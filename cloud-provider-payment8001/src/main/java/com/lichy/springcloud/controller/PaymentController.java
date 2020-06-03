package com.lichy.springcloud.controller;

import com.lichy.springcloud.entities.CommonResult;
import com.lichy.springcloud.entities.Payment;
import com.lichy.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        logger.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功，服务端口" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败，服务端口" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        logger.info("获取结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，服务端口" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有记录，查询id为" + id + "，服务端口" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
