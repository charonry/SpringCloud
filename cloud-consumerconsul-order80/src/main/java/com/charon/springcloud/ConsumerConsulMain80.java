package com.charon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-05 22:48
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMain80.class,args);
    }
}
