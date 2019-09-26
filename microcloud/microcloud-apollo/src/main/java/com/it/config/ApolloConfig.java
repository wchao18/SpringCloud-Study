package com.it.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description apollo配置文件
 * @date 2019/09/25 11:15
 */
@Configuration
@ConfigurationProperties(prefix = "config")
@Data
@RefreshScope   //单个属性注入会自动刷新的，bean注入不会自动刷新，需要加@RefreshScope和配置类结合使用
public class ApolloConfig {


    private String ip;

    private String name;

}
