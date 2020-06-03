package com.lichy.springcloudalibaba.dao;

import com.lichy.springcloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    /**
     * 新建订单
     *
     * @param order 订单
     */
    void create(Order order);

    /**
     * 订单状态
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
