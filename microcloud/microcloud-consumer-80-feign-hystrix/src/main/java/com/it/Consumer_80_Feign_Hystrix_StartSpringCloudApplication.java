package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.it"})
//PS:注意加了feign-client的服务降级以后，要扫描到服务降级配置的类如：IDeptClientServiceFallBackFactory
public class Consumer_80_Feign_Hystrix_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_Feign_Hystrix_StartSpringCloudApplication.class,
                args);
    }
}
