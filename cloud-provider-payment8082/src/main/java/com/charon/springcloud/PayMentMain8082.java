package com.charon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: SpringCloud
 * @description 主启动类
 * @author: charon
 * @create: 2020-11-30 23:31
 **/
@SpringBootApplication
@EnableEurekaClient
public class PayMentMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8082.class,args);
    }
}
