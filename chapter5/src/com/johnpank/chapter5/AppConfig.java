package com.johnpank.chapter5;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public BeanWithSomeMethod bwsm(){ return new BeanWithSomeMethod(); }

    @Bean
    public AspectJAdvice aspectJAdvice(){
        return new AspectJAdvice();
    }


}
