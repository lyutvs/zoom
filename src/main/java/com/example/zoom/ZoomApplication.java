package com.example.zoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ZoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoomApplication.class, args);
    }

}
