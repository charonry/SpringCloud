package com.charon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-04 23:52
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PayMentMain8084 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8084.class,args);
    }
}
