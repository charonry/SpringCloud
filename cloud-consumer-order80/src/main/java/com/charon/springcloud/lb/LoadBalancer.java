package com.charon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-07 21:14
 **/
public interface LoadBalancer {
    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
