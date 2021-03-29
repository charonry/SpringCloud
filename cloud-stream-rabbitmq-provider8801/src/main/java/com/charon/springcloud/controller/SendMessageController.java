package com.charon.springcloud.controller;

import com.charon.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-12 22:13
 **/
@RestController
public class SendMessageController {
    @Resource
    IMessageProvider iMessageProvider;


    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }

}
