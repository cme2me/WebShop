package com.gb.shop.aop;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@Component
@NoArgsConstructor
public class Stats {
    private static AtomicLong productServiceTime;
    private static AtomicLong basketServiceTime;
    private static AtomicLong userServiceTime;

    @PostConstruct
    private static void initTime() {
        productServiceTime = new AtomicLong();
        basketServiceTime = new AtomicLong();
        userServiceTime = new AtomicLong();
    }

    public static void addProductsTime(long ms) {
        productServiceTime.getAndAdd(ms);
    }

    public static void addBasketTime(long ms) {
        basketServiceTime.getAndAdd(ms);
    }

    public static void addUserTime(long ms) {
        userServiceTime.getAndAdd(ms);
    }

    public static StatDTO getStatistic() {
        return new StatDTO(productServiceTime.get(), basketServiceTime.get(), userServiceTime.get());
    }
}
