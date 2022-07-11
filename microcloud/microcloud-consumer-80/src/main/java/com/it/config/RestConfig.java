package com.it.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/29 16:59
 */
@Configuration
public class RestConfig {

    /**
     * 1.默认轮询
     * 2.ribbon的loadbalance,服务如果挂一台，服务没找到，还是会报错的，下一次请求就可以了（很危险！！）
     * 3.这种走不了ip+port的形式
     */
    @Primary
    @LoadBalanced
    @Bean("restTemplate2")
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }

/*
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/
}
