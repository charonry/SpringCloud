package com.charon.springcloud.alibaba.controller;

import com.charon.springcloud.alibaba.domain.CommonResult;
import com.charon.springcloud.alibaba.domain.Order;
import com.charon.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2021-02-22 21:33
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
