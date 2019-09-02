package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Consumer_80_Feign_Hystrix_StartSpringCloudApplication {


    /** 监控web:http://127.0.0.1:9001/hystrix
     * 获取监信息：http://127.0.0.1:8001/hystrix.stream
     */
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_Feign_Hystrix_StartSpringCloudApplication.class,
                args);
    }
}
