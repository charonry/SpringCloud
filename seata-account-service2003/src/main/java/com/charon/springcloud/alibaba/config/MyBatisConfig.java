package com.charon.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2021-02-22 21:20
 **/
@Configuration
@MapperScan({"com.charon.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
