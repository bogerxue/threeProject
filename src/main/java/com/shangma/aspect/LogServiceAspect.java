package com.shangma.aspect;

import com.alibaba.fastjson.JSON;
import com.shangma.common.util.JedisUtil;
import com.shangma.entity.LogEntity;
import com.shangma.service.LogService;
import lombok.extern.slf4j.Slf4j;
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

/**
 * @author BOGEY
 * 2022/7/19  17:04
 */
@Aspect
@Component
@Slf4j
public class LogServiceAspect {

    @Autowired
    private LogService logService;

    private LogEntity logEntity = null;

    private final static Logger logger = LoggerFactory.getLogger(LogServiceAspect.class);


    /**
     * 日志管理
     */
    @Pointcut("execution(* com.shangma.controller..*.*(..))")
    public void addLog() {
    }

    @Around("addLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Jedis jedis = JedisUtil.getJedis();
        Object result = null;
        StringBuilder sbLog = new StringBuilder("\n");
        try {
//            sbLog.append(String.format("用户登录名：%s\r\n",JSON.parseObject(
//                                                                jedis.get("logInUser"),
//                                                                       User.class).getUserLoginName()));
            sbLog.append(String.format("类名：%s\r\n", pjp.getTarget().getClass().getName()));
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            sbLog.append(String.format("方法：%s\r\n", methodSignature.getMethod().getName()));
            Object[] args = pjp.getArgs();
            for (Object o : args) {
                sbLog.append(String.format("参数：%s\r\n", JSON.toJSON(o)));
            }

            long startTime = System.currentTimeMillis();
            result = pjp.proceed();
            long endTime = System.currentTimeMillis();
            sbLog.append(String.format("返回：%s\r\n", JSON.toJSON(result)));
            sbLog.append(String.format("耗时：%sms", endTime - startTime));
        } catch (Exception ex) {
            sbLog.append(String.format("异常：%s", ex.getMessage()));
        } finally {
            logger.info(sbLog.toString());
        }
        return result;

    }
}
