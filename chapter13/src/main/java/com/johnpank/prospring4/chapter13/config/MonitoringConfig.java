package com.johnpank.prospring4.chapter13.config;

import com.johnpank.prospring4.chapter13.monitoring.AppStatistic;
import com.johnpank.prospring4.chapter13.monitoring.AppStatisticImpl;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.stat.internal.StatisticsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MonitoringConfig {
    //monitoring
    @Bean
    AppStatistic appStatistic() {
        return new AppStatisticImpl();
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    SessionFactory sessionFactory(){
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean
    StatisticsImpl hibernateStatisticsBean(){
        return new StatisticsImpl((SessionFactoryImplementor) sessionFactory());
    }

    @Bean
    MBeanExporter jmxExporter() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("bean:name=User_counter", appStatistic());
        beans.put("bean:name=DataBase_statistic", hibernateStatisticsBean());
        exporter.setBeans(beans);
        return exporter;
    }
}
