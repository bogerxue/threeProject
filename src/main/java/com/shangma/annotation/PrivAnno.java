package com.shangma.annotation;


import com.shangma.enums.PrivEnum;

import java.lang.annotation.*;

/**
 * @author: xyz
 * @className: PrivAnno
 * @description:
 * @date: 2022/6/25 17:54
 */
// 注解要用在方法上
@Target({ElementType.METHOD,ElementType.TYPE})
// 注解要存活到运行阶段
@Retention(RetentionPolicy.RUNTIME)
@Documented //该注解是否可以生成到API文档中
public @interface PrivAnno {
    // 方法需要的权限数组           默认值
    PrivEnum[] value() default PrivEnum.CUST;
}
