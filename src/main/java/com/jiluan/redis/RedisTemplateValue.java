package com.jiluan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/27
 * @description: ${description}
 **/
@Component
public class RedisTemplateValue {

    @Resource
    RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        redisTemplate.opsForValue().set("2111", "11111");
        redisTemplate.opsForValue().set("2112", "11112");
        redisTemplate.opsForValue().set("2113", "11113");
        redisTemplate.opsForValue().set("2114", "11114");
        redisTemplate.opsForValue().set("2115", "11115");
        redisTemplate.opsForValue().set("2116", "11116");
        redisTemplate.opsForValue().set("2117", "11116");
        redisTemplate.opsForValue().set("2118", "11116");
        redisTemplate.opsForValue().set("2119", "11116");
        redisTemplate.opsForValue().set("2120", "11116");
        redisTemplate.opsForValue().set("2121", 10);
        redisTemplate.opsForValue().set("2122", 10.1);
    }

    /**
     * 设置指定 key 的值
     */
    public void set () {
        redisTemplate.opsForValue().set("2110", "2110");
    }

    /**
     * 获取指定 key 的值
     */
    public void get () {
        System.out.println(redisTemplate.opsForValue().get("2111"));
    }

    /**
     * 返回 key 中字符串值的子字符
     */
    public void getRange () {
        System.out.println(redisTemplate.opsForValue().get("2111", 0, 3));
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)
     */
    public void getAndSet () {
        System.out.println(redisTemplate.opsForValue().getAndSet("2111", "xxxx"));
    }

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
     */
    public void getBit () {
        System.out.println(redisTemplate.opsForValue().getBit("2112", 2));
    }

    /**
     * 批量获取
     */
    public void multiGet () {
        List<String> keys = new ArrayList<>();
        keys.add("2112");
        keys.add("2113");
        keys.add("2114");
        System.out.println(redisTemplate.opsForValue().multiGet(keys));
    }

    /**
     * 设置ASCII码, 字符串'a'的ASCII码是97, 转为二进制是'01100001', 此方法是将二进制第offset位值变为value
     */
    public void setBit () {
        System.out.println(redisTemplate.opsForValue().setBit("2113", 3, true));
    }

    /**
     * 将值 value 关联到 key ，并将 key 的过期时间设为 timeout
     */
    public void setExpire () {
        redisTemplate.opsForValue().set("8880", "8880", 10, TimeUnit.SECONDS);
    }

    /**
     * 只有在 key 不存在时设置 key 的值
     * 之前已经存在返回false, 不存在返回true
     */
    public void setIfAbsent () {
        System.out.println(redisTemplate.opsForValue().setIfAbsent("8880", "8880"));
        System.out.println(redisTemplate.opsForValue().setIfAbsent("8881", "8881"));
    }

    /**
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始
     */
    public void setRange () {
        redisTemplate.opsForValue().set("2114", "123456789", 2);
    }

    /**
     * 获取字符串的长度
     */
    public void size () {
        System.out.println(redisTemplate.opsForValue().size("2114"));
    }

    /**
     * 批量添加
     */
    public void multiSet () {
        Map<String, String> map = new HashMap<>();
        map.put("8882", "8882");
        map.put("8883", "8883");
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在
     * 之前已经存在返回false, 不存在返回true
     */
    public void multiSetIfAbsent () {
        Map<String, String> map = new HashMap<>();
        map.put("8884", "8882");
        map.put("8885", "8883");
        redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    /**
     * 增加(自增长), 负数则为自减
     */
    public void increment () {
        System.out.println(redisTemplate.opsForValue().increment("2121", 10L));
    }

    /**
     * 增加(自增长), 负数则为自减
     */
    public void incrByFloat () {
        System.out.println(redisTemplate.opsForValue().increment("2122", 10.2F));
    }

    /**
     * 追加到末尾
     */
    public void append () {
        System.out.println(redisTemplate.opsForValue().append("2121", "00000"));
    }
}
