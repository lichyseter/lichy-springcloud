package com.lichy.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public String paymentInfoTimeout(Long id) {
        return "PaymentFallbackService.paymentInfoTimeout";
    }

    @Override
    public String paymentInfoOk(Long id) {
        return "PaymentFallbackService.paymentInfoOk";
    }
}
