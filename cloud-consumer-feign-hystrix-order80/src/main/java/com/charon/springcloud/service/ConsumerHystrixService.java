package com.charon.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-08 23:01
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = ConsumerFallbackService.class)
public interface ConsumerHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String consumerInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String consumerInfo_TimeOut(@PathVariable("id") Integer id);

}
