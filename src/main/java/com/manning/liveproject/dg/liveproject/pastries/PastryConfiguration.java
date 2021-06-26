package com.manning.liveproject.dg.liveproject.pastries;

import domain.pastries.PastryPersistencePort;
import domain.pastries.PastryServiceImpl;
import domain.pastries.PastryServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PastryConfiguration {

    final PastryPersistencePort pastryPersistencePort;

    public PastryConfiguration(PastryPersistencePort pastryPersistencePort) {
        this.pastryPersistencePort = pastryPersistencePort;
    }

    @Bean
    public PastryServicePort pastryServicePort() {
        return new PastryServiceImpl(pastryPersistencePort);
    }

}
