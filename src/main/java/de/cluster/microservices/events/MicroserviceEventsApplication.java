package de.cluster.microservices.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                MicroserviceEventsApplication.class, args);
    }
}
