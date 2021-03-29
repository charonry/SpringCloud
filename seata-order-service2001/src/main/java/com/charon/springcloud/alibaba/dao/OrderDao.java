package com.charon.springcloud.alibaba.dao;

import com.charon.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2021-02-22 21:20
 **/
@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
