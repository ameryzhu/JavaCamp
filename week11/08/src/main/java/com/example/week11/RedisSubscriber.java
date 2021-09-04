package com.example.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Component
public class RedisSubscriber extends MessageListenerAdapter {

    private final RedisTemplate<String, String> redisTemplate;
    ExecutorService executorService;
    @Qualifier("orderService")
    OrderService orderService;

    public RedisSubscriber(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"orderThread");
            }
        });
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println(message);
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        String msg = redisTemplate.getStringSerializer().deserialize(body);
        String topic = redisTemplate.getStringSerializer().deserialize(channel);
        System.out.println("监听到topic为" + topic + "的消息：" + msg);
        orderService.handlerOrder(msg);
    }

}

