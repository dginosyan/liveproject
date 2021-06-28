package com.manning.liveproject.dg.liveproject.basket;

import domain.basket.BasketPersistenceImpl;
import domain.basket.BasketServiceImpl;
import domain.basket.BasketServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BasketConfiguration {
    @Bean
    @SessionScope
    public BasketServicePort basketServicePort() {
        return new BasketServiceImpl(new BasketPersistenceImpl());
    }
}
