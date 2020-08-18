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

    @Value("${common.name:test}")
    private String config1;

    //测试扩展dataid
    @Value("${ext.name:test}")
    private String extName;

    @GetMapping("/configs")
    public String getConfigs(){
        return config1;
    }

    @GetMapping("/ext")
    public String getExtConfigs(){
        return extName;
    }
}
