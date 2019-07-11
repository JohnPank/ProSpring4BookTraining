package com.johnpank.chapter5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        //region BeforeAdvice
        /*
        //применение совета Before для защиты доступа к методу

        SecurityManager securityManager = new SecurityManager();

        //создание прокси с советом
        SecureBean targetSB = new SecureBean();
        SecurityAdvice securityAdvice = new SecurityAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(targetSB);
        factory.addAdvice(securityAdvice);
        SecureBean secureBean = (SecureBean) factory.getProxy();

        try {
            //no user
            securityManager.logout();
            secureBean.showSecretMessage();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
            System.out.println("");

            //Wrong user
        try {
            securityManager.login("ArcadijParovozov", "qwert");
            secureBean.showSecretMessage();
            securityManager.logout();

        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
            System.out.println("");

            //GoodUser
            securityManager.login("JohnPank", "qwert");
            secureBean.showSecretMessage();
            securityManager.logout();





*/
        //endregion

        //region InterceptorAdvice
        //использование совета "вокруг"

//        SecureBean targetSB = new SecureBean();
//        RoundAdvice roundAdvice = new RoundAdvice();
//        ProxyFactory factory = new ProxyFactory();
//        factory.setTarget(targetSB);
//        factory.addAdvice(roundAdvice);
//        SecureBean secureBean = (SecureBean) factory.getProxy();
//        secureBean.showSecretMessage();
//        secureBean.showOpenMessage();

        //endregion

        //region StaticPointCut

//        BeanWithSomeMethod bwsm = new BeanWithSomeMethod();
//        RoundAdvice roundAdvice = new RoundAdvice();
//        MyStaticPointCut myStaticPointCut = new MyStaticPointCut();
//
//        System.out.println("start without point cut");
//        bwsm.method1();
//        bwsm.method2();
//        bwsm.method3();
//
//        System.out.println("start with point cut");
//
//        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
//        pointcutAdvisor.setPointcut(myStaticPointCut);
//        pointcutAdvisor.setAdvice(roundAdvice);
//
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.addAdvisor(pointcutAdvisor);
//        proxyFactory.setTarget(bwsm);
//        BeanWithSomeMethod proxyBWSM = (BeanWithSomeMethod) proxyFactory.getProxy();
//
//        proxyBWSM.method1();
//        proxyBWSM.method2();
//        proxyBWSM.method3();

        //endregion

        //region DynamicPointCut

//        BeanWithSomeMethod bwsm = new BeanWithSomeMethod();
//        RoundAdvice roundAdvice = new RoundAdvice();
//        MyDynamicPointCut dynamicPointCut = new MyDynamicPointCut();
//        Advisor advisor = new DefaultPointcutAdvisor(dynamicPointCut, roundAdvice);
//
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.addAdvisor(advisor);
//        proxyFactory.setTarget(bwsm);
//
//        BeanWithSomeMethod proxyBWSM = (BeanWithSomeMethod) proxyFactory.getProxy();
//
//        proxyBWSM.method4(20);
//        proxyBWSM.method4(40);
//        proxyBWSM.method4(60);
//        proxyBWSM.method4(80);
//        proxyBWSM.method4(100);
//        proxyBWSM.method4(110);
//        proxyBWSM.method4(120);


        //endregion

        //region AnnotationAdvice
//        BeanWithSomeMethod target = new BeanWithSomeMethod();
//        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
//        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new RoundAdvice());
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(target);
//        proxyFactory.addAdvisor(advisor);
//
//        BeanWithSomeMethod proxy = (BeanWithSomeMethod) proxyFactory.getProxy();
//        System.out.println("target without advice");
//        target.method1();
//        target.method2();
//
//        System.out.println();
//        System.out.println("proxy with advice");
//        proxy.method1();
//        proxy.method2();
        //endregion

        //region AspectJAnnotation
        BeanWithSomeMethod bwsm = (BeanWithSomeMethod) context.getBean("bwsm");

        bwsm.method1();
        bwsm.method2();

        //endregion

        context.close();
    }
}
