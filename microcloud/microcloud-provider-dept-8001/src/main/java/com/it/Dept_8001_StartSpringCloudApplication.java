package com.it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.it.dao")
public class Dept_8001_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dept_8001_StartSpringCloudApplication.class,args);
    }
}
