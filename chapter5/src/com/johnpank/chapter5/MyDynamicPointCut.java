package com.johnpank.chapter5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcher;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class MyDynamicPointCut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        if(method.getName().equals("method4")){
            return true;
        }
        return false;
    }

    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        int x = (Integer)objects[0];
        if(x < 100){
            System.out.println("norm");
            return true;
        }else {
            System.out.println("dohua");
            return false;
        }
    }

    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return aClass == BeanWithSomeMethod.class;
            }
        };
    }
}
