package com.trivadis.spring.user.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (Math.random() > 0.5) {
            return Health.down().withDetail("error", "random").build();
        }
        return Health.up().build();
    }
}
