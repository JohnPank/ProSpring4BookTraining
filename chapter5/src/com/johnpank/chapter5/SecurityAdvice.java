package com.johnpank.chapter5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedUser();

        if(userInfo == null){
            System.out.println("Нет авторизованного пользователя");
            throw new SecurityException("Вы должны авторизоваться, прежде чем выполниться метод: " + method.getName());
        }else if(userInfo.getUserName().equals("JohnPank")){
            System.out.println("Welcome " + userInfo.getUserName());
        }else {
            System.out.println("Доступ закрыт");
            throw new SecurityException("Недостаточно прав для выполнения метода: " + method.getName());
        }
    }
}
