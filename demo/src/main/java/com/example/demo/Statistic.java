package com.example.demo;


import com.example.demo.event.NewPhotoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Statistic {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @EventListener
    void onNewPhotoEvent(NewPhotoEvent event){
        log.info("New photo: {}", event);

    }
}
