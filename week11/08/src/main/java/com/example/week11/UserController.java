package com.example.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final DataService service;

    public UserController(@Qualifier("redisService") DataService service) {
        this.service = service;
    }

    @RequestMapping(value = "/set",params = {"key","value"})
    public void setValue(@RequestParam String key,@RequestParam String value){
        System.out.println("request params:key:"+key+",value:"+value);
        service.insertData(key,value);
    }

    @RequestMapping(value = "/get",params = {"key"})
    public String getValue(@RequestParam String key){
        System.out.println("get key:"+key);
        return service.queryData(key);
    }



}
