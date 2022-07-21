package com.shangma.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author BOGEY
 * 2022/7/21  15:35
 */
public class JedisUtil {
    private static JedisPool jedisPool;
    private static JedisPoolConfig jedisPoolConfig;

    // 静态代码块   随着类的加载而执行   类只在第一次使用时加载一次
    static {
        // 创建JedisPool配置对象
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);//最多连接数量
        jedisPoolConfig.setMaxWaitMillis(1000);//等待时间
        jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
    }

    {
        // 在每次创建对象时会被调用 优先执行于构造方法之前
        System.out.println("构造代码块");
    }

    public JedisUtil() {
        // 在每次创建对象时会被调用
        System.out.println("构造方法");
    }


    /**
     * 从连接池中获取一个jedis
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 释放资源
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
