package com.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/17 18:02
 */

@SpringBootApplication
@EnableDiscoveryClient
public class Service1Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Service1Bootstrap.class, args);
    }


}
