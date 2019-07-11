package com.johnpank.chapter5;

import org.springframework.stereotype.Component;

@Component("bwsm")
public class BeanWithSomeMethod {

    //@AdviceRequired
    public void method1(){
        System.out.println("method1 is running");
    }

    public void method2(){
        System.out.println("method2 is running");
    }

    public void method3(){
        System.out.println("method3 is running");
    }

    public void method4(int i){
        System.out.println("method4 is running with parametr " + i);
    }
}
