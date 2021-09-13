package com.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/17 19:45
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${redis.port}")
    private String config1;

    @Value("${mysql.port}")
    private String config2;

    @GetMapping("/config1")
    public String getConfigs(){
        return config1;
    }

    @GetMapping("/config2")
    public String getExtConfigs(){
        return config2;
    }
}
