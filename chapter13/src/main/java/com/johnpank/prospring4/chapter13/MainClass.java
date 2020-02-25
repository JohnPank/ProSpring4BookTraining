package com.johnpank.prospring4.chapter13;

import com.johnpank.prospring4.chapter13.config.AppConfig;
import com.johnpank.prospring4.chapter13.entity.User;
import com.johnpank.prospring4.chapter13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {

    public static void main(String[] args) {
        System.out.println("Start app");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = (UserService) context.getBean("userService");
//
//       // System.out.println("create user");
//
//        User user = new User();
////        user.setName("Some User");
////        user.setPassword("qwerty");
////        user.setEmail("SoUs@post.ru");
////        user = userService.save(user);
////
////        System.out.println("user created: id=" + user.getId());
//
//        System.out.println("reading user");
//
//        user = userService.findById(1l);
//        System.out.println(user);
//
//
//        context.close();

        System.out.println("Stop app");
    }
}



