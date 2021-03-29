package com.charon.springcloud.dao;

import com.charon.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 21:37
 **/
@Mapper
public interface PaymentDao {

    Payment getPaymentById(@Param("id") Long id);

    int create(Payment payment);
 }
