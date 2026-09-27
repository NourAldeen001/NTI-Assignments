package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

//    @Before("org.example.common.CommonPointcut.beforePointcut()")
//    public void loggingBefore(JoinPoint joinPoint) {
//        System.out.println("Logging Before " + joinPoint.getSignature());
//    }
//
//    @After("execution(* org.example.service.*.*(..))")
//    public void loggingAfterFinally(JoinPoint joinPoint) {
//        System.out.println("Logging After Finally " + joinPoint.getSignature());
//    }
//
//    @AfterReturning(
//            pointcut = "execution(* org.example.service.*.*(..))",
//            returning = "result"
//    )
//    public void loggingAfterReturning(JoinPoint joinPoint, Object result) {
//        System.out.println("Logging After Returning " + joinPoint.getSignature() + " result: " + result);
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* org.example.service.*.*(..))",
//            throwing = "ex"
//    )
//    public void loggingAfterThrowing(JoinPoint joinPoint, RuntimeException ex) {
//        System.out.println("Logging After Throwing " + joinPoint.getSignature() + " Exception: " + ex);
//    }
//
//
//    @Around("execution(* org.example.service.*.*(..))")
//    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        System.out.println("START: " + proceedingJoinPoint.getSignature());
//
//        Object result = proceedingJoinPoint.proceed();
//
//        System.out.println("END: " + proceedingJoinPoint.getSignature() + " took "
//                + (System.currentTimeMillis() - start) + "ms");
//
//        return result;
//    }

}
