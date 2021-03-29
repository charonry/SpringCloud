package com.charon.springcloud.service;

import com.charon.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 21:57
 **/
public interface PaymentService {
    Payment getPaymentById(@Param("id") Long id);

    int create(Payment payment);
}
