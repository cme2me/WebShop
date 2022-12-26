package com.gb.shop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class CollectingAspect {
    @Pointcut("execution(public * com.gb.shop.controller.ProductController.*(..))")
    private void productControllerMethod() {
    }

    @Pointcut("execution(public * com.gb.shop.controller.UserController.*(..))")
    private void userControllerMethod() {
    }

    @Pointcut("execution(public * com.gb.shop.controller.BasketController.*(..))")
    private void basketControllerMethod() {
    }


    @Around("productControllerMethod()")
    public Object addProductTiming(ProceedingJoinPoint pjp) throws Throwable {
        long startingTime = System.currentTimeMillis();
        Object object = pjp.proceed();
        long endingTime = System.currentTimeMillis();
        Stats.addProductsTime(endingTime - startingTime);

        return object;
    }

    @Around("userControllerMethod()")
    public Object addUserTiming(ProceedingJoinPoint pjp) throws Throwable {
        long startingTime = System.currentTimeMillis();
        Object object = pjp.proceed();
        long endingTime = System.currentTimeMillis();
        Stats.addUserTime(endingTime - startingTime);

        return object;
    }

    @Around("basketControllerMethod()")
    public Object addBasketTiming(ProceedingJoinPoint pjp) throws Throwable {
        long startingTime = System.currentTimeMillis();
        Object object = pjp.proceed();
        long endingTime = System.currentTimeMillis();
        Stats.addBasketTime(endingTime - startingTime);

        return object;
    }
}
