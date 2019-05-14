package com.johnpank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        Grunt grunt = (Grunt) ctx.getBean("grunt");
        System.out.println(grunt.getSummary());
    }
}
