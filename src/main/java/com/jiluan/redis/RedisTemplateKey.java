package com.jiluan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/27
 * @description: ${description}
 **/
@Component
public class RedisTemplateKey {

    @Resource
    RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        redisTemplate.opsForValue().set("1111", "11111");
        redisTemplate.opsForValue().set("1112", "11112");
        redisTemplate.opsForValue().set("1113", "11113");
        redisTemplate.opsForValue().set("1114", "11114");
        redisTemplate.opsForValue().set("1115", "11115");
        redisTemplate.opsForValue().set("1116", "11116");
        redisTemplate.opsForValue().set("1117", "11116");
        redisTemplate.opsForValue().set("1118", "11116");
        redisTemplate.opsForValue().set("1119", "11116");
        redisTemplate.opsForValue().set("1120", "11116");
    }

    /**
     * 删除key
     */
    public void delete () {
        redisTemplate.delete("1111");
    }

    /**
     * 批量删除key
     */
    public void deleteList () {
        List<String> keys = new ArrayList<>();
        keys.add("1112");
        keys.add("1113");
        redisTemplate.delete(keys);
    }

    /**
     * 序列化key
     */
    public void dump () {
        System.out.println(redisTemplate.dump("1117"));
    }

    /**
     * 是否存在key
     */
    public void hasKey () {
        System.out.println(redisTemplate.hasKey("1116"));
        System.out.println(redisTemplate.hasKey("1117"));
    }

    /**
     * 设置过期时间
     */
    public void expire () {
        redisTemplate.expire("1114", 5, TimeUnit.SECONDS);
    }

    /**
     * 设置过期时间
     */
    public void expireAt () {
        redisTemplate.expireAt("1115", new Date());
    }

    /**
     * 查找匹配的key
     */
    public void keys () {
        System.out.println(redisTemplate.keys("111" + "*"));
    }

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     */
    public void move () {
        redisTemplate.move("1116", 3);
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     */
    public void persist () {
        redisTemplate.expire("1117", 5, TimeUnit.SECONDS);
        redisTemplate.persist("1117");
    }

    /**
     * 返回 key 的剩余的过期时间
     */
    public void getExpire () {
        redisTemplate.expire("1117", 5, TimeUnit.MINUTES);
        System.out.println(redisTemplate.getExpire("1117", TimeUnit.SECONDS));
    }

    /**
     * 返回 key 的剩余的过期时间
     */
    public void getExpireTimne () {
        redisTemplate.getExpire("1117");
    }

    /**
     * 从当前数据库中随机返回一个 key
     */
    public void randomKey () {
        System.out.println(redisTemplate.randomKey());
    }

    /**
     * 修改 key 的名称
     */
    public void rename () {
        redisTemplate.rename("1118", "8888");
    }

    /**
     * 仅当 newkey 不存在时，将 oldKey 改名为 newkey
     */
    public void renameIfAbsent () {
        redisTemplate.renameIfAbsent("1119", "8888");
        redisTemplate.renameIfAbsent("1119", "9999");
    }

    /**
     * 返回 key 所储存的值的类型
     *
     */
    public DataType type () {
        return redisTemplate.type("1120");
    }

}
