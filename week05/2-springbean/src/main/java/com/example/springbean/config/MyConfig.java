package com.example.springbean.config;

import com.example.springbean.beans.MyConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Object configBean(){
        return new MyConfigBean();
    }
}
