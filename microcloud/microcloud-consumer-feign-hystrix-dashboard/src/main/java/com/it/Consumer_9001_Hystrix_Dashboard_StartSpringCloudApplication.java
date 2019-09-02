package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Consumer_9001_Hystrix_Dashboard_StartSpringCloudApplication {


    /** dashboard监控web:http://127.0.0.1:9001/hystrix
     * 获取监信息：http://127.0.0.1:8001/hystrix.stream(服务提供者)
     */
    public static void main(String[] args) {
        SpringApplication.run(Consumer_9001_Hystrix_Dashboard_StartSpringCloudApplication.class,
                args);
    }
}
