package com.charon.springcloud.controller;

import com.charon.springcloud.entities.CommonResult;
import com.charon.springcloud.entities.Payment;
import com.charon.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 22:52
 **/
@RestController
@Slf4j
public class OrderController {

    //static final String PAYMENT_URL = "http://localhost:8081";

     static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        /** postForObject
         * 1.url: 请求地址
         * 2.request: 请求参数
         * 3.responseType: 返回的数据
         */
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        /** postForObject（返回对象为响应体中数据转化为对象：Json）
         * 1.url: 请求地址
         * 2.responseType: 返回的数据
         */
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id){
        /** getForEntity（返回responseEntity对象含有相应中一些信息响应头、响应状态码） 返回需要加上getBody方法
         * 1.url: 请求地址
         * 2.responseType: 返回的数据
         */
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info("ResponseEntity{}",entity);
            return entity.getBody();
        }else{
            return new CommonResult<>(400,"操作失败");
        }
    }


    @GetMapping("/consumer/payment/getForEntity/create")
    public CommonResult<Payment> createEntity(Payment payment){
        /** postForEntity
         * 1.url: 请求地址
         * 2.request: 请求参数
         * 3.responseType: 返回的数据
         */
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(400,"操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.serviceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8081"+"/payment/zipkin/", String.class);
        return result;
    }
}
