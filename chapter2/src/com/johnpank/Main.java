package com.johnpank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
	    MessageRenderer messageRenderer = (MessageRenderer) context.getBean("renderer");
	    messageRenderer.render();
    }
}
