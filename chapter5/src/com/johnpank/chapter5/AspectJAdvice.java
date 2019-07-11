package com.johnpank.chapter5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJAdvice {
    @Pointcut("execution(* com.johnpank.chapter5.BeanWithSomeMethod.method1())")
    public void methodExecution(){
    }

    @Around("methodExecution()")
    public Object simpleAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("AspectJ annotation before");
        Object returned = proceedingJoinPoint.proceed();
        System.out.println("AspectJ annotation after");
        return returned;
    }

}
