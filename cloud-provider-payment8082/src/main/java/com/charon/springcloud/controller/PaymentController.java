package com.charon.springcloud.controller;

import com.charon.springcloud.entities.CommonResult;
import com.charon.springcloud.entities.Payment;
import com.charon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 22:01
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;



    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入成功;端口号为"+serverPort,result);
        }else {
            return new CommonResult(400,"插入失败端口号为"+serverPort,null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功端口号为"+serverPort,payment);
        }else {
            return new CommonResult(400,"查询失败端口号为"+serverPort,id);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


}
