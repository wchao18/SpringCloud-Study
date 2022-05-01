package com.it;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//web访问路径：http://127.0.0.1/hystrix
//监控服务url: http://localhost/actuator/hystrix.stream
@EnableHystrixDashboard
@EnableFeignClients(basePackages = {"com.it.service"})
public class Consumer_80_Feign_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_Feign_StartSpringCloudApplication.class,
                args);
    }
}
