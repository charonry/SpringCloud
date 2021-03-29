package com.charon.springcloud.service.impl;

import com.charon.springcloud.dao.PaymentDao;
import com.charon.springcloud.entities.Payment;
import com.charon.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 21:59
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
}
