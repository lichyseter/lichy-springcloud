package com.lichy.springcloud.service;

/**
 * 数据访问Service
 *
 * @author lichy
 */
public interface PaymentService {

    public String paymentInfoOk(Long id);

    public String paymentInfoTimeout(Long id);

}
