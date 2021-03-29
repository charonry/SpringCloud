package com.charon.springcloud.controller;

import com.charon.springcloud.entities.CommonResult;
import com.charon.springcloud.entities.Payment;
import com.charon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 22:01
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入成功;端口号为"+serverPort,result);
        }else {
            return new CommonResult(400,"插入失败;端口号为"+serverPort,null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功;端口号为"+serverPort,payment);
        }else {
            return new CommonResult(400,"查询失败;端口号为"+serverPort,id);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        // 获取注册中心的服务
        List<String> services = discoveryClient.getServices();
        for(String element: services){
            log.info("***element***"+element);
        }
        // 获取指定服务名的服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+
                    instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to zipkin ";
    }
}
