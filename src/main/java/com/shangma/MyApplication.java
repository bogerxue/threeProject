package com.shangma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author:
 * @description:
 * @className:
 * @date: 2022/7/14 21:26
 */
@SpringBootApplication
@MapperScan(basePackages = "com.shangma.mapper")
@EnableTransactionManagement
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}
