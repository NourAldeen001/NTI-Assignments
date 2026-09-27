package org.example.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.example.advices.LoggingAfterReturning;
import org.example.advices.LoggingBeforeAdvice;
import org.example.advices.LoggingThrowsAdvice;
import org.example.advices.TimingInterceptor;
import org.example.service.InventoryService;
import org.example.service.InventoryServiceImpl;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class AppConfig {

    @Bean
    public AfterReturningAdvice loggingAfterReturning() {
        return new LoggingAfterReturning();
    }

    @Bean
    public MethodBeforeAdvice loggingBeforeAdvice() {
        return new LoggingBeforeAdvice();
    }
    @Bean
    public ThrowsAdvice loggingThrowsAdvice() {
        return new LoggingThrowsAdvice();
    }
    @Bean
    public MethodInterceptor timingInterceptor() {
        return new TimingInterceptor();
    }

    @Bean
    public InventoryServiceImpl inventoryServiceTarget() {
        return new InventoryServiceImpl();
    }

    @Bean
    public InventoryService inventoryServiceWithNameMatchPoint() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("reserveStock");
        ProxyFactory factory = new ProxyFactory(inventoryServiceTarget());
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, loggingBeforeAdvice());
        factory.addAdvisor(advisor);

        return (InventoryService) factory.getProxy();
    }

    @Bean
    public ProxyFactoryBean inventoryService() {
        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setTarget(inventoryServiceTarget());
        factory.setInterceptorNames(
                "loggingAfterReturning",
                "loggingBeforeAdvice",
                "loggingThrowsAdvice",
                "timingInterceptor"
        );
        return factory;
    }

}
