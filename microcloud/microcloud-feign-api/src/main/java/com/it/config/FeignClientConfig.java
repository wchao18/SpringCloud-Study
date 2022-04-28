package com.it.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description feign客户端配置
 * @date 2019/08/29 17:30
 */
@Configuration
public class FeignClientConfig {

    public Logger.Level feignLogger(){
        return feign.Logger.Level.FULL;
    }

   /* @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "123456");
    }*/


}
