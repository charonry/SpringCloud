package com.charon.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-16 21:50
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class PayMentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain9001.class, args);
    }
}
