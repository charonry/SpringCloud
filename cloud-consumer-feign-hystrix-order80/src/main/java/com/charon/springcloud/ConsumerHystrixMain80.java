package com.charon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-08 22:58
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixMain80 {
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerHystrixMain80.class,args);
    }
}
