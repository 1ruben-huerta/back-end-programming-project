package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class D288CommandLineRunner implements CommandLineRunner {

    @Value("${rubenproperty}")
    private String myProperty;

    private static final Logger log = LoggerFactory.getLogger(D288CommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("Ruben is " + myProperty);
    }
}

