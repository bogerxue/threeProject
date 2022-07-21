package com.shangma.common.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author BOGEY
 * 2022/7/19  17:25
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * SpringBoot中有一个ControllerAdvice的注解，使用该注解表示开启了全局异常的捕获
     */


    @ExceptionHandler(value =Exception.class)
    public String exceptionHandler(Exception e){
        System.out.println("有个异常！原因是:"+e);
        return e.getMessage();
    }
}
