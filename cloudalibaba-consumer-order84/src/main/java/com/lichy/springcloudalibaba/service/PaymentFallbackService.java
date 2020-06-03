package com.lichy.springcloudalibaba.service;

import com.lichy.springcloud.entities.CommonResult;
import com.lichy.springcloud.entities.Payment;

public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult(444, "服务降级返回", new Payment(id, null));
    }
}
