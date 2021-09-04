package com.example.week11;

import io.netty.util.internal.StringUtil;
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

    public synchronized String getOrder(String orderNum){
        String number = queryData("order_remain");
        if(StringUtil.isNullOrEmpty(number)){
            return "0";
        }else{
            int rest = Integer.parseInt(number);
            int orderInt = Integer.parseInt(orderNum);
            String result = "" + (rest - orderInt);
            insertData("order_remain", "" + result);
            return result;
        }
    }
}
