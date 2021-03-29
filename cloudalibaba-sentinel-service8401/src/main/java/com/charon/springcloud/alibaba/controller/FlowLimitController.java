package com.charon.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-22 22:10
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        // 暂停测试线程数
       /* try {
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (Exception e){
            log.error("testA出错{}",e.getMessage());
        }*/
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       log.info("testD 测试RT");
        return "------testD";*/
        log.info("testD 异常比例");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    /**
     * 热点规则 报错不会执行blockHandler兜底方法；blockHandler只管控控制台配置
     * @param p1 参数1
     * @param p2 参数2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    /**
     * 自定义返回的友好提示页面
     * @param p1 参数1
     * @param p2 参数2
     * @param exception 异常信息
     * @return
     */
    public String deal_testHotKey (String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------deal_testHotKey-------";
    }

}
