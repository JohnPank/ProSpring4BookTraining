package com.johnpank.chapter4;

public class MethodInitBean {
    private String someText;

    public MethodInitBean(){
        System.out.println("const MethodInitBean");
        someText = "Немного теста добавлено в конструкторе MethodInitBean";
    }

    public void initMethod(){
        System.out.println("init MethodInitBean");
        someText = "Немного теста добавлено в initMethod MethodInitBean";
    }

    public void destroyMethod(){
        System.out.println("MethodInitBean destroyed");
    }

    public String toString(){
        return someText;
    }
}
