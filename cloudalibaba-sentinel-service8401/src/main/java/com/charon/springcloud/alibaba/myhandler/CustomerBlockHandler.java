package com.charon.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.charon.springcloud.entities.CommonResult;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-28 22:40
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }

}
