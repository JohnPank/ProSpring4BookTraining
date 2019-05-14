package com.johnpank.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {

    public static void main(String[] args) {

        //xml config
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
        //((ClassPathXmlApplicationContext) ctx).registerShutdownHook();

        //JavaConfig
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaAppConfig.class);
        ((AnnotationConfigApplicationContext) ctx).registerShutdownHook();

        //region Init beans
/*
        System.out.println("Create beans");
        System.out.println("--------------------------------------------");

        //вызов метода при инициализации бина
        MethodInitBean miBean = (MethodInitBean) ctx.getBean("methodInitBean");
        System.out.println(miBean);

        System.out.println("--------------------------------------------");

        //инициализации бина через интерфейс
        InterfaceInitBean iiBean = (InterfaceInitBean) ctx.getBean("interfaceInitBean");
        System.out.println(iiBean);

        System.out.println("--------------------------------------------");

        //инициализации бина через аннотации
        AnnotationInitBean aiBean = (AnnotationInitBean) ctx.getBean("annotationInitBean");
        System.out.println(aiBean);

        System.out.println("");
        System.out.println("Destroy beans");
        System.out.println("--------------------------------------------");
*/
        //endregion

        //region Bean name

//        WhatMyNameBean wmnBean = (WhatMyNameBean) ctx.getBean("whatMyNameBean");
//        System.out.println(wmnBean);

        //endregion

        //region Property Editor
//        NameShower nameShower= (NameShower) ctx.getBean("nameShowerBean");
//        System.out.println(nameShower.name);
        //endregion

        //region Localisation

//        MultiLanguageBean mlBean = (MultiLanguageBean) ctx.getBean("multiLanguageBean");
//        System.out.println(mlBean.getEngText());
//        System.out.println(mlBean.getRusText());

        //endregion

        //region JavaConfig

        StringReceiver stringReceiver = ctx.getBean("stringReceiver",StringReceiver.class);
        stringReceiver.showString();

        //endregion

    }
}
