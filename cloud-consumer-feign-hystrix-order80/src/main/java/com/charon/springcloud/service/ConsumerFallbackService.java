package com.charon.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-09 22:42
 **/
@Component
public class ConsumerFallbackService implements ConsumerHystrixService {
    @Override
    public String consumerInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String consumerInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
