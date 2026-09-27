package org.example.advices;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LoggingAfterReturning implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AFTER LOGGING: method name " + method.getName() + " target: " + target + " with return value: " + returnValue);
    }
}
