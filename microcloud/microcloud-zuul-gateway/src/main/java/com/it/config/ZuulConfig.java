package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/09/03 11:18
 */
@Configuration
public class ZuulConfig {

    @Bean
    public AuthorizedFilter authorizedFilter() {
        return new AuthorizedFilter();
    }
}
