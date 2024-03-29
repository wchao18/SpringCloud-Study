package com.it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.it.dao")
@EnableEurekaClient
@EnableCircuitBreaker
public class Dept_8001_Hystrix_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dept_8001_Hystrix_StartSpringCloudApplication.class,args);
    }
}
