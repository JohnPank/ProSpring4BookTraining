package com.johnpank.prospring4.chapter13.config;

import com.johnpank.prospring4.chapter13.service.UserService;
import com.johnpank.prospring4.chapter13.service.UserServiceImpl;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@ComponentScan("com.johnpank.prospring4.chapter13.service") //поиск всех сервисов
@EnableJpaRepositories("com.johnpank.prospring4.chapter13.repository")
public class TestAppConfig {

    private static final String PROP_DATABASE_DRIVER = "org.h2.Driver";
    private static final String PROP_DATABASE_URL = "jdbc:h2:/home/johnpank/JavaProject/ProSpring4/chapter13/src/test/resources/dataBase/test_users_db";
    private static final String PROP_DATABASE_USERNAME = "admin";
    private static final String PROP_DATABASE_PASSWORD = "admin";

    private static final String PROP_HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "true";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.johnpank.prospring4.chapter13.entity";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "update";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(PROP_DATABASE_DRIVER);
        dataSource.setUrl(PROP_DATABASE_URL);
        dataSource.setUsername(PROP_DATABASE_USERNAME);
        dataSource.setPassword(PROP_DATABASE_PASSWORD);
        return dataSource;
    }

    //Создание конкретного сервиса который тестируется
    @Bean
    UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", PROP_HIBERNATE_DIALECT);
        properties.put("hibernate.show_sql", PROP_HIBERNATE_SHOW_SQL);
        properties.put("hibernate.hbm2ddl.auto", PROP_HIBERNATE_HBM2DDL_AUTO);
        return properties;
    }

//    @Bean(name = "databaseTester")
//    public DataSourceDatabaseTester dataSourceDatabaseTester(){
//        return new DataSourceDatabaseTester(dataSource());
//    }
//
//    //парсер екселевского документа
//    @Bean(name = "xlsDataFileLoader")
//    public XlsDataFileLoader xlsDataFileLoader(){
//        return new XlsDataFileLoader();
//    }

}

//    Тестовая информация подготовлена на рабочем листе электронной таблицы под
//    именем, совпадающим с именем таблицы в базе данных.
//    В первой строке
//    рабочего листа указаны имена столбцов этой таблицы, а начиная со второй строки
//    введены данные. столбец id оставить пустым (заполняется самой бд).