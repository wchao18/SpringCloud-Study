package com.it;

import com.extend.MyLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "ribbonClient",configuration = MyLoadBalanceConfig.class)
public class Consumer_80_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_StartSpringCloudApplication.class,
                args);
    }
}
