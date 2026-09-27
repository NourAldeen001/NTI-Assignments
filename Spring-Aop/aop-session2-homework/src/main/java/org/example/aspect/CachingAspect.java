package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
@Order(2)
public class CachingAspect {

    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    @Around("@annotation(org.example.annotation.Cacheable)")
    public Object annotationCacheableAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String key = (String) proceedingJoinPoint.getArgs()[0];
        if(cache.containsKey(key)) {
            System.out.println("CACHE HIT");
            return cache.get(key);
        }
        Object result = proceedingJoinPoint.proceed();
        cache.put(key, result);
        return result;
    }
}
