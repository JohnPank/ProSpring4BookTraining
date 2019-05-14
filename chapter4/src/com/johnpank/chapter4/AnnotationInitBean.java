package com.johnpank.chapter4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationInitBean {
    String someText;

    public AnnotationInitBean(){
        System.out.println("const AnnotationInitBean");
        someText = "Немного теста добавлено в конструкторе AnnotationInitBean";
    }

    @PostConstruct
    public void postConstructMethod(){
        System.out.println("postConstruct AnnotationInitBean");
        someText = "Немного теста добавлено в postConstruct AnnotationInitBean";
    }

    @PreDestroy
    public void preDestroyMethod(){
        System.out.println("PreDestroy AnnotationInitBean");
    }

    public String toString(){
        return someText;
    }
}
