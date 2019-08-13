package code.com.johnpank.chapter7;

import code.com.johnpank.chapter7.dao.UserDAO;
import code.com.johnpank.chapter7.models.Note;
import code.com.johnpank.chapter7.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Bean
    @Lazy(value = true)
    public SessionFactory sessionFactory(){
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("resourses/hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Note.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    @Bean
    @Lazy(value = true)
    @Autowired
    public UserDAO userDAO(){
        return new UserDAO(sessionFactory());
    }
}
