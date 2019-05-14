package com.johnpank.chapter4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class JavaAppConfig {

    @Bean
    @Lazy(value = true)
    public StringGeter stringGeter(){
        return new StringGeter();
    }

    @Bean
    @Autowired
    @Lazy(value = true)
    public StringReceiver stringReceiver(StringGeter stringGeter){
        return new StringReceiver(stringGeter);
    }
}
