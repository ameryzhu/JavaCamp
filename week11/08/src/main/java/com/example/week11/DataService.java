package com.example.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("redisService")
public class DataService {
    private final RedisTemplate<String, String> redisTemplate;

    public DataService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public synchronized void insertData(String key,String value){
        System.out.println("request params:key:"+key+",value:"+value);
        redisTemplate.opsForValue().set(key, value);
    }

    public synchronized String queryData(String key){
        System.out.println("request params:key:"+key);
        return redisTemplate.opsForValue().get(key);
    }
}
