package com.manning.liveproject.dg.liveproject.order;

import domain.order.OrderServiceImpl;
import domain.order.OrderServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    OrderServicePort orderServicePort() {
        return new OrderServiceImpl(new OrderPersistenceImpl());
    }

}
