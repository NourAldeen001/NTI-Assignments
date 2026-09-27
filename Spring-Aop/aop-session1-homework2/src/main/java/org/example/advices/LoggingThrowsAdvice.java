package org.example.advices;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class LoggingThrowsAdvice implements ThrowsAdvice {

//    public void afterThrowing(Exception ex) {
//        System.out.println("ERROR: " + ex.getMessage());
//    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("ERROR in " + method.getName() + ": " + ex.getMessage());
    }
}

