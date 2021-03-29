package com.charon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-07 21:17
 **/
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取当前请求次数
     * @return
     */
    public final  int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >+ Integer.MAX_VALUE ? 0:current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*********next访问次数为："+next);
        return  next;
    }



    /**
     * 负载均衡算法：
     *      第几次请求书%（取余）服务集群总数 =  实际调用服务器位置下标，每次重启rest从1开始。
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
