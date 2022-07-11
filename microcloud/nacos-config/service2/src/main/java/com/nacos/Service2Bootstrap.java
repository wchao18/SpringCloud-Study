package com.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/17 18:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Service2Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Service2Bootstrap.class, args);
    }


}
