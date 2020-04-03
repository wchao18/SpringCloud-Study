package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/04/01 16:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StartSpringCloudApplicationConsul {

    public static void main(String[] args) {
        SpringApplication.run(StartSpringCloudApplicationConsul.class);
    }
}
