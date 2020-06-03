package com.lichy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 主启动类
 * @author lichy
 */
@SpringBootApplication
@EnableHystrixDashboard
public class PaymentHystrixDashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixDashboard9001.class, args);
    }
}
