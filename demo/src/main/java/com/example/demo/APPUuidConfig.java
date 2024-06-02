package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.UUID;

@Configuration
public class APPUuidConfig {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    @Primary String appUuid(){
        String uuid = UUID.randomUUID().toString();
        log.info("uuid->{}", uuid);
        return uuid;
    }
    @Bean String shorterAppUuid(){
        String uuid = appUuid().substring(0, appUuid().length()/2);
        log.info("uuid->{}", uuid);
        return uuid;
    }

//    @Bean
//    UUID appUuid(){
//        UUID uuid = UUID.randomUUID();
//        log.info("uuid ->{}", uuid);
//        return uuid;
//    }
}
