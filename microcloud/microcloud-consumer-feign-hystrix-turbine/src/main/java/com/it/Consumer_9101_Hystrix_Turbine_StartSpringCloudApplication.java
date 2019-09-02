package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class Consumer_9101_Hystrix_Turbine_StartSpringCloudApplication {


    /** dashboard监控web:http://127.0.0.1:9001/hystrix
     *  turbine web：http://127.0.0.1:9101/turbine.stream(整个服务提供者)
     * 获取监信息：http://127.0.0.1:8001/hystrix.stream(单个服务提供者)
     * PS:权限的问题 在microcloud-consumer-80-feign-hystrix-turbine的application.yml或者security模块屏蔽了接口拦截
     */
    public static void main(String[] args) {
        SpringApplication.run(Consumer_9101_Hystrix_Turbine_StartSpringCloudApplication.class,
                args);
    }
}
