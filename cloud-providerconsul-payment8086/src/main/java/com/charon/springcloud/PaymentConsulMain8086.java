package com.charon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-05 22:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8086 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8086.class,args);
    }
}
