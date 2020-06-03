package com.lichy.springcloudalibaba.service.impl;

import com.lichy.springcloudalibaba.dao.OrderDao;
import com.lichy.springcloudalibaba.domain.Order;
import com.lichy.springcloudalibaba.service.AccountService;
import com.lichy.springcloudalibaba.service.OrderService;
import com.lichy.springcloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@Service
public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name="fsp-create_order",rollbackFor = Exception.class)
    public void create(Order order) {
        logger.info("开始创建订单");
        orderDao.create(order);
        logger.info("开始调用库存,做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        logger.info("开始调用库存,做扣减结束");
        logger.info("开始调用库存,做扣钱");
        accountService.decrease(order.getUserId(), order.getMoney());
        logger.info("开始调用库存,做扣钱结束");

        logger.info("修改订单状态");
        orderDao.update(order.getUserId(), 0);
        logger.info("修改订单状态完成");
    }


}
