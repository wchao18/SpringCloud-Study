package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.it.service"})
public class Consumer_80_Feign_Hystrix_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_Feign_Hystrix_StartSpringCloudApplication.class,
                args);
    }
}
