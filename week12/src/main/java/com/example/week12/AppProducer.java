package com.example.week12;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {
    public static void main(String agrs[]){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService producerService = (ProducerService) applicationContext.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("消息编号："+i);
        }
        applicationContext.close();
    }
}