package com.charon.springcloud.controller;

import com.charon.springcloud.entities.CommonResult;
import com.charon.springcloud.entities.Payment;
import com.charon.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-07 22:55
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        return paymentFeignService.paymentFeignTimeout();
    }
}
