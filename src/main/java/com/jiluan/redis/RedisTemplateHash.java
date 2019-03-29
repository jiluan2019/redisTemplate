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
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/28
 * @description: ${description}
 **/
@Component
public class RedisTemplateHash {

    @Resource
    RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        redisTemplate.opsForHash().put("4111", "11111", "11111");
        redisTemplate.opsForHash().put("4111", "11112", "11112");
        redisTemplate.opsForHash().put("4111", "11113", "11113");
        redisTemplate.opsForHash().put("4111", "11114", "11114");
        redisTemplate.opsForHash().put("4111", "11115", "11115");
        redisTemplate.opsForHash().put("4111", "11116", "11116");
        redisTemplate.opsForHash().put("4111", "11117", "11117");
        redisTemplate.opsForHash().put("4111", "11118", "11118");
        redisTemplate.opsForHash().put("4111", "11105", 1);
        redisTemplate.opsForHash().put("4111", "11106", 1.5);
    }

    /**
     * 获取存储在哈希表中指定字段的值
     */
    public void get () {
        System.out.println(redisTemplate.opsForHash().get("4111", "11111"));
    }

    /**
     * 获取所有给定字段的值
     */
    public void entries () {
        System.out.println(redisTemplate.opsForHash().entries("4111"));
    }

    /**
     * 获取所有给定字段的值
     */
    public void multiGet () {
        Collection<String> fields = new ArrayList<>();
        fields.add("11112");
        fields.add("11113");
        fields.add("11114");
        System.out.println(redisTemplate.opsForHash().multiGet("4111", fields));
    }

    public void put () {
        redisTemplate.opsForHash().put("4111", "11119", "11119");
    }

    public void putAll () {
        Map<String, String> map = new HashMap<>();
        map.put("11101", "11101");
        map.put("11102", "11102");
        map.put("11103", "11103");
        redisTemplate.opsForHash().putAll("4111", map);
    }

    /**
     * 仅当hashKey不存在时才设置
     */
    public void putIfAbsent () {
        redisTemplate.opsForHash().putIfAbsent("4111", "11104", "11119");
    }

    /**
     * 删除一个或多个哈希表字段
     */
    public void delete () {
        redisTemplate.opsForHash().delete("4111", "11102", "11101");
    }

    /**
     * 查看哈希表 key 中，指定的字段是否存在
     */
    public void hasKey () {
        System.out.println(redisTemplate.opsForHash().hasKey("4111", "11102"));
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     */
    public void increment () {
        System.out.println(redisTemplate.opsForHash().increment("4111", "11105", 1L));
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     */
    public void incrementFloat () {
        System.out.println(redisTemplate.opsForHash().increment("4111", "11106", 1.2F));
    }

    /**
     * 获取所有哈希表中的字段
     */
    public void keys () {
        System.out.println(redisTemplate.opsForHash().keys("4111"));
    }

    /**
     * 获取哈希表中字段的数量
     */
    public void size () {
        System.out.println(redisTemplate.opsForHash().size("4111"));
    }

    /**
     * 获取哈希表中所有值
     */
    public void values () {
        System.out.println(redisTemplate.opsForHash().values("4111"));
    }

    /**
     * 迭代哈希表中的键值对
     *
     */
    public void scan () {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("4111", ScanOptions.NONE);
        while (cursor.hasNext()) {
            Map.Entry<Object, Object> entry = cursor.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
