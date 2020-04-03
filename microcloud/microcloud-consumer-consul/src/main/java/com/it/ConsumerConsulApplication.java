package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/04/02 17:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulApplication.class);
    }
}
