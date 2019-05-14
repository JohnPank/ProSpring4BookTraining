package com.johnpank.chapter4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WhatMyNameBean implements BeanNameAware, ApplicationContextAware {

    private String myName;
    private ApplicationContext myContext;

    public void setBeanName(String name) {
        myName = name;
    }

    @Override
    public String toString() {
        return "I'm bean with name " + myName +
                "\nI live in " + myContext.getDisplayName() + " application";
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        myContext = applicationContext;
    }
}
