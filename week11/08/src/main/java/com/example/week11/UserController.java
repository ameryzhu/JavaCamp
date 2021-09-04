package com.example.week11;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final DataService service;

    public UserController(@Qualifier("redisService") DataService service) {
        this.service = service;
    }

    @RequestMapping(value = "/set", params = {"key", "value"})
    public void setValue(@RequestParam String key, @RequestParam String value) {
        System.out.println("request params:key:" + key + ",value:" + value);
        service.insertData(key, value);
    }

    @RequestMapping(value = "/get", params = {"key"})
    public String getValue(@RequestParam String key) {
        System.out.println("get key:" + key);
        return service.queryData(key);
    }

    @RequestMapping(value = "/order/remain", params = {"orderNum"})
    @ResponseBody
    public String getOrder(@RequestParam String orderNum) {
        System.out.println("request params:" + orderNum);
        return service.getOrder(orderNum);
    }



}
