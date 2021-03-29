package com.charon.springcloud.alibaba.service;

import com.charon.springcloud.entities.CommonResult;
import com.charon.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-29 22:06
 **/
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
