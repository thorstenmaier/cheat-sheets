package com.example.javashutdownhooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class JavaShutdownHooksApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(JavaShutdownHooksApplication.class, args);

        // Register shutdown hook "The Java Way"
        // Spring has already registered its own shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("### shutdown hook \"The Java Way\" called");
            }
        }));

        // Set liveness to broken after 10 seconds
        // Standalone mode: Application will not shut down
        // Kubernetes: Liveness state will cause a SIG TERM which will shut down the java application
        Thread.sleep(10_000);
        AvailabilityChangeEvent.publish(context, LivenessState.BROKEN);
    }

    @Bean
    ApplicationListener<AvailabilityChangeEvent<?>> availabilityChangeEventApplicationListener() {
        return event -> System.out.println("### New AvailabilityChangeEvent - " + event.getResolvableType() + ": " + event.getState());
    }

}
