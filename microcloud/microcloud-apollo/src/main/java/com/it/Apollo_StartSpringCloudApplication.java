package com.it;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.it.config.ApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(value = {ApolloConfig.class})
@EnableApolloConfig(value = "application") //默认的命名空间(namespace)是application
public class Apollo_StartSpringCloudApplication {
    public static void main(String[] args) {

        SpringApplication.run(Apollo_StartSpringCloudApplication.class, args);
    }
}
