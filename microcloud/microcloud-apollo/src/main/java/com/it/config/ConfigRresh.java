package com.it.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description 自动刷新配置类
 * @date 2019/09/25 16:57
 */
@Configuration
@Slf4j
public class ConfigRresh {

    @Autowired
    private ApolloConfig apolloConfig;

    @Autowired
    private RefreshScope refreshScope;


    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent configChangeEvent) {
        for (String key : configChangeEvent.changedKeys()) {
            log.error("change key:{}", key);
        }
        refreshScope.refresh("apolloConfig");
    }


    public static void main(String[] args) {
        //默认命名空间是application
        Config appConfig = ConfigService.getAppConfig();
        String key = "sms.token";
        String property = appConfig.getProperty(key, null);
        System.out.println("sms.token.value:" + property);
    }
}
