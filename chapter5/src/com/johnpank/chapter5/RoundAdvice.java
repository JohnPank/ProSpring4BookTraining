package com.johnpank.chapter5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class RoundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Перед вызовом метода");
        Object returnVal = invocation.proceed();
        System.out.println("После вызовом метода");
        return returnVal;
    }
}
