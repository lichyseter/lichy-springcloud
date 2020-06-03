package com.lichy.springcloud.service.impl;

import com.lichy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Long id) {
        return "线程:" + Thread.currentThread().getName() + " paymentInfoOk:" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Long id) {
        int seconds = 5;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程:" + Thread.currentThread().getName() + " 耗时" + seconds + "秒钟， paymentInfoTimeout:" + id;
    }

    public String timeoutHandler(Long id) {
        return "线程:" + Thread.currentThread().getName() + " timeoutHandler钟， id:" + id;
    }
}
