package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/29 17:30
 */
@Configuration
public class HeaderConfig {

    /**
     * base64加密
     */
    @Bean
    public HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", generateBasicAuth());
        return httpHeaders;
    }


    private static String generateBasicAuth() {
        String auth = "admin:123456";
        byte[] encode = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encode);
        return authHeader;
    }
}
