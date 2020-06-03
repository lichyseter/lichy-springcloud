package com.lichy.springcloudalibaba.controller;

import com.lichy.springcloud.entities.CommonResult;
import com.lichy.springcloudalibaba.domain.Order;
import com.lichy.springcloudalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
