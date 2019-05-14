package com.johnpank.chapter4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InterfaceInitBean implements InitializingBean, DisposableBean {

    String someText;

    public InterfaceInitBean(){
        System.out.println("const InterfaceInitBean");
        someText = "Немного теста добавлено в конструкторе InterfaceInitBean";
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("interface init method InterfaceInitBean");
        someText = "Немного теста добавлено в методе реализующем интерфейс InitializingBean в классе InterfaceInitBean";
    }

    public String toString(){
        return someText;
    }

    public void destroy() throws Exception {
        System.out.println("interface destroy method InterfaceInitBean");
    }
}
