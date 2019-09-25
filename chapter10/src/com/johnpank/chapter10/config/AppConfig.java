package com.johnpank.chapter10.config;

import com.johnpank.chapter10.converters.StringToIntConverter;
import com.johnpank.chapter10.converters.StringToYodaTimeConverter;
import com.johnpank.chapter10.model.Mobilka;
import com.johnpank.chapter10.model.Smartphone;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.johnpank.chapter10")
@PropertySource("classpath:mobilka.proprerties")
public class AppConfig {
    @Autowired
    Environment env;

    @Autowired
    StringToYodaTimeConverter timeConverter;

    @Autowired
    StringToIntConverter toIntConverter;


    @Bean
    public StringToYodaTimeConverter timeConverter(){
        //return new StringToYodaTimeConverter(env.getProperty("date.pattern"));
        return new StringToYodaTimeConverter();
    }

    @Bean
    public Mobilka mobilka(){
        Mobilka mobilka = new Mobilka();
        mobilka.setVendor(env.getProperty("mobilka.vendor"));
        mobilka.setModel(env.getProperty("mobilka.model"));
        mobilka.setRelease((DateTime) timeConverter.convert(env.getProperty("mobilka.release")));
        return mobilka;
    }

    @Bean
    public Smartphone smartphone(){
        Smartphone smartphone = new Smartphone();
        smartphone.setVendor(env.getProperty("smart.vendor"));
        smartphone.setModel(env.getProperty("smart.model"));
        smartphone.setRelease((DateTime) timeConverter.convert(env.getProperty("smart.release")));
        smartphone.setAndroidVerAPI((int) toIntConverter.convert(env.getProperty("smart.androidVerAPI")));
        return smartphone;
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }

}
