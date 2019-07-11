package com.johnpank.chapter5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class MyStaticPointCut extends StaticMethodMatcherPointcut {
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return aClass == BeanWithSomeMethod.class;
            }
        };
    }

    public boolean matches(Method method, Class<?> aClass) {
        if(method.getName().equals("method2")){
            return true;
        }
        return false;
    }
}
