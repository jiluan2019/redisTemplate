package com.jiluan.redis;

import com.jiluan.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuolin
 * @program: redisTemplate
 * @date 2019/3/29
 * @description: ${description}
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTemplateTest {

    @Autowired
    RedisTemplateKey redisTemplateKey;

    @Test
    public void redisTemplateKeyTest () {
        redisTemplateKey.delete();
        redisTemplateKey.deleteList();
        redisTemplateKey.dump();
        redisTemplateKey.hasKey();
        redisTemplateKey.expire();
        redisTemplateKey.expireAt();
        redisTemplateKey.getExpire();
        redisTemplateKey.getExpireTimne();
        redisTemplateKey.keys();
        redisTemplateKey.move();
        redisTemplateKey.persist();
        redisTemplateKey.randomKey();
        redisTemplateKey.rename();
        redisTemplateKey.renameIfAbsent();
        redisTemplateKey.type();
    }

    @Autowired
    RedisTemplateValue redisTemplateValue;

    @Test
    public void redisTemplateValueTest () {
        redisTemplateValue.append();
        redisTemplateValue.get();
        redisTemplateValue.getAndSet();
        redisTemplateValue.getBit();
        redisTemplateValue.getRange();
        redisTemplateValue.incrByFloat();
        redisTemplateValue.increment();
        redisTemplateValue.multiGet();
        redisTemplateValue.multiSet();
        redisTemplateValue.multiSetIfAbsent();
        redisTemplateValue.set();
        redisTemplateValue.setBit();
        redisTemplateValue.setExpire();
        redisTemplateValue.setIfAbsent();
        redisTemplateValue.setRange();
        redisTemplateValue.size();
    }

    @Autowired
    RedisTemplateList redisTemplateList;

    @Test
    public void redisTemplateListTest () {
        redisTemplateList.index();
        redisTemplateList.leftPop();
        redisTemplateList.leftPopWait();
        redisTemplateList.leftPush();
        redisTemplateList.leftPushAll();
        redisTemplateList.leftPushAllCollection();
        redisTemplateList.leftPushBefore();
        redisTemplateList.leftPushIfPresent();
        redisTemplateList.range();
        redisTemplateList.remove();
        redisTemplateList.rightPop();
        redisTemplateList.rightPopAndLeftPush();
        redisTemplateList.rightPopAndLeftPushWait();
        redisTemplateList.rightPopWait();
        redisTemplateList.rightPush();
        redisTemplateList.rightPushAfter();
        redisTemplateList.rightPushAll();
        redisTemplateList.rightPushAllCollection();
        redisTemplateList.rightPushIfPresent();
        redisTemplateList.set();
        redisTemplateList.size();
        redisTemplateList.trim();
    }

    @Autowired
    RedisTemplateHash redisTemplateHash;

    @Test
    public void redisTemplateHashTest () {
        redisTemplateHash.delete();
        redisTemplateHash.entries();
        redisTemplateHash.get();
        redisTemplateHash.hasKey();
        redisTemplateHash.incrementFloat();
        redisTemplateHash.keys();
        redisTemplateHash.increment();
        redisTemplateHash.multiGet();
        redisTemplateHash.put();
        redisTemplateHash.putAll();
        redisTemplateHash.putIfAbsent();
        redisTemplateHash.scan();
        redisTemplateHash.size();
        redisTemplateHash.values();
    }

    @Autowired
    RedisTemplateSet redisTemplateSet;

    @Test
    public void redisTemplateSetTest () {
        redisTemplateSet.add();
        redisTemplateSet.difference();
        redisTemplateSet.differenceAndStore();
        redisTemplateSet.differenceAndStoreCollection();
        redisTemplateSet.differenceCollection();
        redisTemplateSet.distinctRandomMembers();
        redisTemplateSet.intersect();
        redisTemplateSet.intersectAndStoreCollection();
        redisTemplateSet.intersectCollection();
        redisTemplateSet.isMember();
        redisTemplateSet.members();
        redisTemplateSet.move();
        redisTemplateSet.pop();
        redisTemplateSet.randomMember();
        redisTemplateSet.randomMembers();
        redisTemplateSet.remove();
        redisTemplateSet.scan();
        redisTemplateSet.intersectAndStore();
        redisTemplateSet.size();
        redisTemplateSet.union();
        redisTemplateSet.unionAndStore();
        redisTemplateSet.unionAndStoreCollection();
        redisTemplateSet.unionCollection();
    }

    @Autowired
    RedisTemplateZSet redisTemplateZSet;

    @Test
    public void redisTemplateZSetTest () {
        redisTemplateZSet.add();
        redisTemplateZSet.addSet();
        redisTemplateZSet.count();
        redisTemplateZSet.incrementScore();
        redisTemplateZSet.intersectAndStore();
        redisTemplateZSet.intersectAndStoreCollection();
        redisTemplateZSet.range();
        redisTemplateZSet.rangeByScore();
        redisTemplateZSet.rangeByScoreWithScores();
        redisTemplateZSet.rangeByScoreWithScoresRange();
        redisTemplateZSet.rangeWithScores();
        redisTemplateZSet.rank();
        redisTemplateZSet.remove();
        redisTemplateZSet.removeRange();
        redisTemplateZSet.reverseRange();
        redisTemplateZSet.reverseRangeByScore();
        redisTemplateZSet.reverseRangeByScoreRange();
        redisTemplateZSet.reverseRangeByScoreWithScores();
        redisTemplateZSet.reverseRangeWithScores();
        redisTemplateZSet.reverseRank();
        redisTemplateZSet.scan();
        redisTemplateZSet.score();
        redisTemplateZSet.size();
        redisTemplateZSet.unionAndStore();
        redisTemplateZSet.unionAndStoreCollection();
        redisTemplateZSet.zCard();
        redisTemplateZSet.zRemoveRangeByScore();
    }
}