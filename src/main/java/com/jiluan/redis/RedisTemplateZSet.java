package com.jiluan.redis;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.redis.core.ZSetOperations.TypedTuple;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/28
 * @description: ${description}
 **/
@Component
public class RedisTemplateZSet {

    @Resource
    RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        Set<TypedTuple<String>> values = new HashSet<>();
        TypedTuple<String> value = null;
        for (int i = 0; i < 10; i++) {
            value = new DefaultTypedTuple("1111" + i, Double.valueOf(i));
            values.add(value);
        }
        redisTemplate.opsForZSet().add("60000", values);

        Set<TypedTuple<String>> values1 = new HashSet<>();
        TypedTuple<String> value1 = null;
        for (int i = 7; i < 10; i++) {
            value1 = new DefaultTypedTuple("1111" + i, Double.valueOf(i));
            values1.add(value1);
        }
        redisTemplate.opsForZSet().add("60001", values1);
        Set<TypedTuple<String>> values2 = new HashSet<>();
        TypedTuple<String> value2 = null;
        for (int i = -3; i < 10; i++) {
            value2 = new DefaultTypedTuple("1111" + i, Double.valueOf(i));
            values2.add(value1);
        }
        redisTemplate.opsForZSet().add("60002", values2);
    }

    /**
     * 添加元素,有序集合是按照元素的score值由小到大排列
     */
    public void add () {
        System.out.println(redisTemplate.opsForZSet().add("60000", "21111", 20));
    }

    /**
     * 添加元素,有序集合是按照元素的score值由小到大排列
     */
    public void addSet () {
        Set<TypedTuple<String>> values = new HashSet<>();
        TypedTuple<String> value = null;
        for (int i = 0; i < 2; i++) {
            value = new DefaultTypedTuple("1111" + i, Double.valueOf(i));
            values.add(value);
        }
        System.out.println(redisTemplate.opsForZSet().add("60001", values));
    }

    /**
     * 移除元素
     */
    public void remove () {
        System.out.println(redisTemplate.opsForZSet().remove("60000", "11111", "11112"));
    }

    /**
     * 增加元素的score值，并返回增加后的值
     */
    public void incrementScore () {
        System.out.println(redisTemplate.opsForZSet().incrementScore("60000", "11118", 20));
    }

    /**
     * 返回元素在集合的排名,有序集合是按照元素的score值由小到大排列
     * 0表示第一位
     */
    public void rank () {
        System.out.println(redisTemplate.opsForZSet().rank("60000", "11118"));
    }

    /**
     * 返回元素在集合的排名,按元素的score值由大到小排列
     */
    public void reverseRank () {
        System.out.println(redisTemplate.opsForZSet().reverseRank("60000", "11118"));
    }

    /**
     * 获取集合的元素, 从小到大排序
     * start 开始位置
     * end   结束位置, -1查询所有
     */
    public void range () {
        System.out.println(redisTemplate.opsForZSet().range("60000", 1, 5));
    }

    /**
     * 获取集合元素, 并且把score值也获取
     */
    public void rangeWithScores () {
        System.out.println(redisTemplate.opsForZSet().rangeWithScores("60000", 1, 5));
    }

    /**
     * 根据Score值查询集合元素
     */
    public void rangeByScore () {
        System.out.println(redisTemplate.opsForZSet().rangeByScore("60000", 2, 1000));
    }

    /**
     * 根据Score值查询集合元素, 从小到大排序
     */
    public void rangeByScoreWithScores () {
        System.out.println(redisTemplate.opsForZSet().rangeByScoreWithScores("60000", 2, 1000));
    }

    /**
     */
    public void rangeByScoreWithScoresRange () {
        System.out.println(redisTemplate.opsForZSet().rangeByScoreWithScores("60000", 3, 5, 2, 1000));
    }

    /**
     * 获取集合的元素, 从大到小排序
     */
    public void reverseRange () {
        System.out.println(redisTemplate.opsForZSet().reverseRange("60000", 1, 5));
    }

    /**
     * 获取集合的元素, 从大到小排序, 并返回score值
     */
    public void reverseRangeWithScores () {
        System.out.println(redisTemplate.opsForZSet().reverseRangeWithScores("60000", 1, 5));
    }

    /**
     * 根据Score值查询集合元素, 从大到小排序
     */
    public void reverseRangeByScore () {
        System.out.println(redisTemplate.opsForZSet().reverseRangeByScore("60000", 2, 1000));
    }

    /**
     * 根据Score值查询集合元素, 从大到小排序
     */
    public void reverseRangeByScoreWithScores () {
        System.out.println(redisTemplate.opsForZSet().reverseRangeByScoreWithScores("60000", 2, 5));
    }

    /**
     */
    public void reverseRangeByScoreRange () {
        System.out.println(redisTemplate.opsForZSet().reverseRangeByScore("60000", 3, 5, 2, 1000));
    }

    /**
     * 根据score值获取集合元素数量
     */
    public void count () {
        System.out.println(redisTemplate.opsForZSet().count("60000", 3, 5));
    }

    /**
     * 获取集合大小
     */
    public void size () {
        System.out.println(redisTemplate.opsForZSet().size("60000"));
    }

    /**
     * 获取集合大小
     */
    public void zCard () {
        System.out.println(redisTemplate.opsForZSet().zCard("60000"));
    }

    /**
     * 获取集合中value元素的score值
     */
    public void score () {
        System.out.println(redisTemplate.opsForZSet().score("60000", "11115"));
    }

    /**
     * 移除指定索引位置的成员
     */
    public void removeRange () {
        System.out.println(redisTemplate.opsForZSet().removeRange("60000", 1, 2));
    }

    /**
     * 根据指定的score值的范围来移除成员
     */
    public void zRemoveRangeByScore () {
        System.out.println(redisTemplate.opsForZSet().removeRangeByScore("60000", 3, 5));
    }

    /**
     * 获取key和otherKey的并集并存储在destKey中
     */
    public void unionAndStore () {
        System.out.println(redisTemplate.opsForZSet().unionAndStore("60000", "60001", "600"));
    }

    /**
     * 获取key和otherKeys的并集并存储在destKey中
     */
    public void unionAndStoreCollection () {
        Collection<String> otherKeys = new ArrayList<>();
        otherKeys.add("60001");
        otherKeys.add("60002");
        System.out.println(redisTemplate.opsForZSet().unionAndStore("60000", otherKeys, "601"));
    }

    /**
     * 交集
     */
    public void intersectAndStore () {
        System.out.println(redisTemplate.opsForZSet().intersectAndStore("60000", "60001", "602"));
    }

    /**
     * 交集
     */
    public void intersectAndStoreCollection () {
        Collection<String> otherKeys = new ArrayList<>();
        otherKeys.add("60001");
        otherKeys.add("60002");
        System.out.println(redisTemplate.opsForZSet().intersectAndStore("60000", otherKeys, "603"));
    }

    /**
     * 迭代子元素
     */
    public void scan () {
        Cursor<TypedTuple> cursor = redisTemplate.opsForZSet().scan("60000", ScanOptions.NONE);
        while (cursor.hasNext()) {
            TypedTuple typedTuple = cursor.next();
            System.out.println(typedTuple.getScore() + ":" + typedTuple.getValue());
        }
    }

}
