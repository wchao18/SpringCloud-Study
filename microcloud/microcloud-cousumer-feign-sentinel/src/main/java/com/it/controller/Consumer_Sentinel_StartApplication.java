package com.it.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.it"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.it"})
public class Consumer_Sentinel_StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Sentinel_StartApplication.class,
                args);
    }
}
