package com.lichy.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lichy.springcloud.entities.CommonResult;
import com.lichy.springcloud.entities.Payment;
import com.lichy.springcloudalibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverURL;

//    @RequestMapping("consumer/paymentSQL/{id}")
//    @SentinelResource(value = "paymentSQL", fallback = "handleFallback")
//    public CommonResult getPayment(@PathVariable("id") Long id) {
//        CommonResult commonResult = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class);
//        if (commonResult.getData() == null) {
//            throw new RuntimeException("没有数据");
//        }
//        return commonResult;
//    }

    public CommonResult handleFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult(444, "异常" + e.getMessage(), new Payment(id, null));

    }

    @Resource
    private PaymentService paymentService;

    @RequestMapping("consumer/paymentSQL/{id}")
    @SentinelResource(value = "paymentSQL", fallback = "handleFallback")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        CommonResult commonResult = paymentService.paymentSQL(id);
        if (commonResult.getData() == null) {
            throw new RuntimeException("没有数据");
        }
        return commonResult;
    }

}
