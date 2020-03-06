package com.johnpank.prospring4.chapter14;

import com.johnpank.prospring4.chapter14.model.Unit;

public class MainClass {
    public static void main(String[] args) {
        //Unit unit = new Unit("Warrior", 20, 10,5, "tank");

        TestGroovyClass testGroovyClass = new TestGroovyClass();
        System.out.println(testGroovyClass.sayHello());
    }
}
