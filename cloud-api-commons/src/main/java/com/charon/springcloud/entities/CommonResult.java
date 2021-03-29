package com.charon.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-01 21:34
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private  T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
