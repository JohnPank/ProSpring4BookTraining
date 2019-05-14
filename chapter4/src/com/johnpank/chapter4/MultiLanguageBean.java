package com.johnpank.chapter4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Locale;

public class MultiLanguageBean implements ApplicationContextAware {
    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public String getEngText(){
        Locale locale = Locale.ENGLISH;
        return context.getMessage("msg", null ,locale);
    }

    public String getRusText(){
        Locale locale = new Locale("ru", "RU");
        return context.getMessage("msg", null ,locale);
    }
}
