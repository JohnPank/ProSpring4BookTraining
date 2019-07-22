package com.johnpank.chapter6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.johnpank.chapter6")
public class AppConfig {


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(DBContract.DATABASE_DRIVER);
        dataSource.setUrl(DBContract.DATABASE_URL);
        dataSource.setUsername(DBContract.DATABASE_USERNAME);
        dataSource.setPassword(DBContract.DATABASE_PASSWORD);

        return dataSource;
    }

    @Bean
    public MorrNpcDAOIimpl getDao(){
        return new MorrNpcDAOIimpl();
    }
}