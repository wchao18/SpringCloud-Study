package com.it.controller;

import com.it.config.ApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description
 * @date 2019/09/25 11:21
 */
@RestController
public class ConfigController {

    @Autowired
    private ApolloConfig apolloConfig;

    @Value("${config.ip:127.0.0.1}")
    private String configIp;

    @GetMapping("/value1")
    public String getValue1() {
        return apolloConfig.toString();
    }

    @GetMapping("/value2")
    public String getValue2() {
        return configIp;
    }
}
