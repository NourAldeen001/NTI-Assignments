package org.example.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonPointcut {

    @Pointcut("execution(* org.example.service.*.*(..))")
    public void beforePointcut() {}
}
