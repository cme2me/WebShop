package com.gb.shop.aop;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

public class Stats {
    private static AtomicLong productServiceTime;
    private static AtomicLong basketServiceTime;

    @PostConstruct
    private static void initTime() {
        productServiceTime = new AtomicLong();
        basketServiceTime = new AtomicLong();

    }

    public static void addProductsTime(long ms) {
        productServiceTime.getAndAdd(ms);
    }

    public static void addBasketTime(long ms) {
        basketServiceTime.getAndAdd(ms);
    }

    public static StatDTO getStatistic() {
        return new StatDTO(productServiceTime.get(), basketServiceTime.get());
    }
}
