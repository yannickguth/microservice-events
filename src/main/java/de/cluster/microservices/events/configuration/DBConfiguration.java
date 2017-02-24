package de.cluster.microservices.events.configuration;

import de.cluster.microservices.events.service.EventService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {

    @Autowired
    private EventService eventService;


    @Bean
    public InitializingBean insert() {

        return new InitializingBean() {
            @Override
            public void afterPropertiesSet() {
                eventService.createData();
            }

        };
    }
}