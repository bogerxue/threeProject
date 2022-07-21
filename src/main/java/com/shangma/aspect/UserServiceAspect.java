package com.shangma.aspect;


import com.alibaba.fastjson.JSON;
import com.shangma.annotation.PrivAnno;
import com.shangma.common.util.JedisUtil;
import com.shangma.entity.User;
import com.shangma.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.security.auth.login.LoginException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author BOGEY
 * 2022/7/19  16:43
 */
@Aspect
@Component
public class UserServiceAspect {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceAspect.class);

    @Autowired
    private UserService userService;

    /**
     * 访问权限监听用户
     */

    @Pointcut("execution(* com.shangma.controller.UserController.*(..))")
    public void logC() {
    }

    @Around("logC()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取访问的目标方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        System.out.println("==>目标方法签名 " + methodSignature);
        System.out.println("==>目标方法 " + targetMethod);
        // 2.获取方法上面是否有PrivAnno注解
        //如果该方法上没有权限注解，直接调用目标方法
        if (!targetMethod.isAnnotationPresent(PrivAnno.class)) {
            //放行
            return pjp.proceed();
        } else {
            //获取目标方法的参数列表(用户名)
            Object[] args = pjp.getArgs();
            if (args == null) {
                throw new LoginException("获取目标方法的参数列表错误");
            }
            Jedis jedis = JedisUtil.getJedis();
            String loginUser = jedis.get("loginUser");
            User user = JSON.parseObject(loginUser, User.class);
            System.out.println(Arrays.toString(args));
            //获取登录名
//            String currentUser = user.getUserLoginName();
            String currentUser = "lisi";//todo
            logger.info("访问用户，{}", currentUser);
            if (userService.isAdmin(currentUser)) {
                logger.info("{},是管理员", currentUser);
                return pjp.proceed();
            } else if (userService.isPermission(currentUser)) {
                logger.info("{},有此权限", currentUser);
                return pjp.proceed();
            } else {
                throw new RuntimeException("权限不足");
            }
        }
    }

}
