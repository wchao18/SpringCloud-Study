package com.it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.it.dao")
//新版本中注册注解不写也是可以的！！
@EnableEurekaClient
public class Dept_8001_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dept_8001_StartSpringCloudApplication.class,args);
    }
}
