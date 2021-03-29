package com.charon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-05 00:28
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkMain80.class,args);
    }
}
