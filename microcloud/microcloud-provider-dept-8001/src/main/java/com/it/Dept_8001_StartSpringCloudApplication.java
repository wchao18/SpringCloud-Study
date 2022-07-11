package com.it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = "com.it.dao")
//新版本(SpingCloud Edgware)中注册注解不写也是可以的！！
//@EnableEurekaClient  //开启Eureka client
@EnableDiscoveryClient //通用注册 比如nacos
@EnableTransactionManagement
public class Dept_8001_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dept_8001_StartSpringCloudApplication.class, args);
    }
}
