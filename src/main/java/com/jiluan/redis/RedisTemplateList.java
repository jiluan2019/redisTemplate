package com.jiluan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/27
 * @description: ${description}
 **/
@Component
public class RedisTemplateList {

    @Resource
    RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        redisTemplate.opsForList().leftPushAll("3111", "11111", "11112",
                "11113", "11114", "11115", "11116", "11117", "11118", "11119", "11120");
    }

    /**
     * 通过索引获取列表中的元素
     */
    public void index () {
        System.out.println(redisTemplate.opsForList().index("3111", 1));
    }

    /**
     * 获取列表指定范围内的元素 0是开始位置  -1返回所有
     */
    public void range () {
        System.out.println(redisTemplate.opsForList().range("3111", 2, 4));
    }

    /**
     * 存储在list头部
     */
    public void leftPush () {
        redisTemplate.opsForList().leftPush("3111", "0003");
    }

    /**
     * 存储在list头部
     */
    public void leftPushAll () {
        redisTemplate.opsForList().leftPushAll("3111", "0000", "0001", "0002");
    }

    /**
     * 存储在list头部
     */
    public void leftPushAllCollection () {
        Collection<String> strings = new ArrayList<>();
        strings.add("001");
        strings.add("002");
        strings.add("003");
        redisTemplate.opsForList().leftPushAll("3111", strings);
    }

    /**
     * 当list存在的时候才加入
     */
    public void leftPushIfPresent () {
        redisTemplate.opsForList().leftPushIfPresent("xxxx", "004");
        redisTemplate.opsForList().leftPushIfPresent("3111", "004");
    }

    /**
     * 如果pivot存在,再pivot前面添加
     */
    public void leftPushBefore () {
        redisTemplate.opsForList().leftPush("3111", "004", "00.");
    }

    /**
     * 存储在list最后
     */
    public void rightPush () {
        redisTemplate.opsForList().rightPush("3111", "3333");
    }

    /**
     * 存储在list最后
     */
    public void rightPushAll () {
        redisTemplate.opsForList().rightPushAll("3111", "3334", "3335", "3336");
    }

    /**
     * 存储在list最后
     */
    public void rightPushAllCollection () {
        Collection<String> strings = new ArrayList<>();
        strings.add("3337");
        strings.add("3338");
        strings.add("3339");
        redisTemplate.opsForList().rightPushAll("3111", strings);
    }

    /**
     * 为已存在的列表添加值
     */
    public void rightPushIfPresent () {
        redisTemplate.opsForList().rightPushIfPresent("3111", "3340");
    }

    /**
     * 在pivot元素的右边添加值
     */
    public void rightPushAfter () {
        redisTemplate.opsForList().rightPush("3111", "3340", "3341");
    }

    /**
     * 通过索引设置列表元素的值
     */
    public void set () {
        redisTemplate.opsForList().set("3111", 1, "xxxxxxx");
    }

    /**
     * 移出并获取列表的第一个元素
     */
    public void leftPop () {
        System.out.println(redisTemplate.opsForList().leftPop("3111"));
    }

    /**
     * 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     */
    public void leftPopWait () {
        System.out.println(redisTemplate.opsForList().leftPop("3111", 1, TimeUnit.SECONDS));
    }

    /**
     * 移除并获取列表最后一个元素
     */
    public void rightPop () {
        System.out.println(redisTemplate.opsForList().rightPop("3111"));
    }

    /**
     * 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     */
    public void rightPopWait () {
        System.out.println(redisTemplate.opsForList().rightPop("3111", 1, TimeUnit.SECONDS));
    }

    /**
     * 移除列表的最后一个元素，并将该元素添加到另一个列表并返回
     */
    public void rightPopAndLeftPush () {
        System.out.println(redisTemplate.opsForList().rightPopAndLeftPush("3111", "3112"));
    }

    /**
     * 从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     */
    public void rightPopAndLeftPushWait () {
        System.out.println(redisTemplate.opsForList().rightPopAndLeftPush("3111", "3112", 1, TimeUnit.SECONDS));
    }

    /**
     * 删除集合中值等于value得元素
     * index=0, 删除所有值等于value的元素; index>0, 从头部开始删除第一个值等于value的元素;
     * index<0, 从尾部开始删除第一个值等于value的元素;
     */
    public void remove () {
        redisTemplate.opsForList().remove("3111", 1, "11118");
    }

    /**
     * 裁剪list
     */
    public void trim () {
        redisTemplate.opsForList().trim("3111", 0, 2);
    }

    /**
     * 获取列表长度
     */
    public void size () {
        System.out.println(redisTemplate.opsForList().size("3111"));
    }

}
