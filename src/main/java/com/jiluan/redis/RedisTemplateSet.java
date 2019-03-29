package com.jiluan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/28
 * @description: ${description}
 **/
@Component
public class RedisTemplateSet {

    @Resource
    RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        redisTemplate.opsForSet().add("5111", "11111", "11112",
                "11113", "11114", "11115", "11116", "11117", "11118", "11119", "11120");
        redisTemplate.opsForSet().add("5112", "11118", "11119", "11120", "11121");
        redisTemplate.opsForSet().add("5113", "11114", "11115", "11116", "11122");
    }


    /**
     * set添加元素
     */
    public void add () {
        redisTemplate.opsForSet().add("5111", "11121", "11122");
    }

    /**
     * set移除元素
     */
    public void remove () {
        redisTemplate.opsForSet().remove("5111", "11121", "11122");
    }

    /**
     * 移除并返回集合的一个随机元素
     */
    public void pop () {
        System.out.println(redisTemplate.opsForSet().pop("5111"));
    }

    /**
     * 将元素value从一个集合移到另一个集合
     */
    public void move () {
        redisTemplate.opsForSet().move("5111", "11111", "5112");
    }

    /**
     * 获取集合的大小
     */
    public void size () {
        System.out.println(redisTemplate.opsForSet().size("5111"));
    }

    /**
     * 判断集合是否包含value
     */
    public Boolean isMember () {
        return redisTemplate.opsForSet().isMember("5111", "11112");
    }

    /**
     * 获取两个集合的交集
     */
    public void intersect () {
        System.out.println(redisTemplate.opsForSet().intersect("5111", "5112"));
    }

    /**
     * 获取key集合与多个集合的交集
     */
    public void intersectCollection () {
        Collection<String> keys = new ArrayList<>();
        keys.add("5112");
        keys.add("5113");
        System.out.println(redisTemplate.opsForSet().intersect("5111", keys));
    }

    /**
     * key集合与otherKey集合的交集存储到destKey集合中
     */
    public void intersectAndStore () {
        System.out.println(redisTemplate.opsForSet().intersectAndStore("5111", "5112", "5000"));
    }

    /**
     * key集合与多个集合的交集存储到destKey集合中
     */
    public void intersectAndStoreCollection () {
        Collection<String> keys = new ArrayList<>();
        keys.add("5112");
        keys.add("5113");
        System.out.println(redisTemplate.opsForSet().intersectAndStore("5111", keys, "5001"));
    }

    /**
     * 获取两个集合的并集
     */
    public void union () {
        System.out.println(redisTemplate.opsForSet().union("5111", "5112"));
    }

    /**
     * 获取key集合与多个集合的并集
     */
    public void unionCollection () {
        Collection<String> keys = new ArrayList<>();
        keys.add("5112");
        keys.add("5113");
        System.out.println(redisTemplate.opsForSet().union("5111", keys));
    }

    /**
     * key集合与otherKey集合的并集存储到destKey中
     */
    public void unionAndStore () {
        System.out.println(redisTemplate.opsForSet().unionAndStore("5111", "5112", "5003"));
    }

    /**
     * key集合与多个集合的并集存储到destKey中
     */
    public void unionAndStoreCollection () {
        Collection<String> keys = new ArrayList<>();
        keys.add("5112");
        keys.add("5113");
        System.out.println(redisTemplate.opsForSet().unionAndStore("5111", keys, "5004"));
    }

    /**
     * 获取两个集合的差集
     */
    public void difference () {
        System.out.println(redisTemplate.opsForSet().difference("5111", "5112"));
    }

    /**
     * 获取key集合与多个集合的差集
     */
    public void differenceCollection () {
        Collection<String> keys = new ArrayList<>();
        keys.add("5112");
        keys.add("5113");
        System.out.println(redisTemplate.opsForSet().difference("5111", keys));
    }

    /**
     * key集合与otherKey集合的差集存储到destKey中
     */
    public void differenceAndStore () {
        System.out.println(redisTemplate.opsForSet().differenceAndStore("5111", "5112", "5004"));
    }

    /**
     * key集合与多个集合的差集存储到destKey中
     */
    public void differenceAndStoreCollection () {
        Collection<String> keys = new ArrayList<>();
        keys.add("5112");
        keys.add("5113");
        System.out.println(redisTemplate.opsForSet().differenceAndStore("5111", keys, "5005"));
    }

    /**
     * 获取集合所有元素
     */
    public void members () {
        System.out.println(redisTemplate.opsForSet().members("5111"));
    }

    /**
     * 随机获取集合中的一个元素
     */
    public void randomMember () {
        System.out.println(redisTemplate.opsForSet().randomMember("5111"));
    }

    /**
     * 随机获取集合中count个元素
     */
    public void randomMembers () {
        System.out.println(redisTemplate.opsForSet().randomMembers("5111", 3));
    }

    /**
     * 随机获取集合中count个元素并且去除重复的
     */
    public void distinctRandomMembers () {
        System.out.println(redisTemplate.opsForSet().distinctRandomMembers("5111", 4));
    }

    /**
     * 迭代子元素
     */
    public void scan () {
        Cursor cursor = redisTemplate.opsForSet().scan("5111", ScanOptions.NONE);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
