package com.lichy.springcloud.service;

import com.lichy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 数据访问Service
 *
 * @author lichy
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
