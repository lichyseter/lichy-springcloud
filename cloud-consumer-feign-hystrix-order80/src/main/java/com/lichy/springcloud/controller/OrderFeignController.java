package com.lichy.springcloud.controller;

import com.lichy.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Long id) {
        return paymentFeignService.paymentInfoTimeout(id);
    }

    public String timeoutHandler(Long id) {
        return "线程:" + Thread.currentThread().getName() + " 客户端超时保护， id:" + id;
    }

    public String globalFallback() {
        return "线程:" + Thread.currentThread().getName() + " 默认的全局fallback";
    }

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id) {
        return paymentFeignService.paymentInfoOk(id);
    }


}
