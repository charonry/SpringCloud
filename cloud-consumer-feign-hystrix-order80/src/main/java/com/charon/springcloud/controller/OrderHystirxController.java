package com.charon.springcloud.controller;

import com.charon.springcloud.service.ConsumerHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-08 23:02
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Resource
    ConsumerHystrixService consumerHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = consumerHystrixService.consumerInfo_OK(id);
        return result;
    }

   /* @HystrixCommand(fallbackMethod ="paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "1500")
    })*/
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age = 10/0;
        String result = consumerHystrixService.consumerInfo_TimeOut(id);
        return result;
    }

    /**
     * 出现超时异常等情况调用的方法
     * @param id
     * @return
     */
     public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
         return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己";
    }


    /**
     *  下面是全局fallback方法
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试!";
    }
}
