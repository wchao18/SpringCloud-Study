package com.it.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/17 15:22
 */
public class DemoMain {

    public static void main(String[] args) throws NacosException, IOException {

        //nacos 地址
        String serverAddr = "server02:8848";
        String dataId = "service1.yml";
        //默认DEFAULT_GROUP
        String group = "TEST_GROUP";
        //命名空间 默认public
        String namespece = "c3964d69-4eb9-458d-bc68-c10c8c808583";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        // 配置用户名：
        properties.put(PropertyKeyConst.USERNAME, "nacos");
        // 配置密码：
        properties.put(PropertyKeyConst.PASSWORD, "nacos");
        properties.put("namespace", namespece);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        //添加配置更新监听
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            //当配置有变化时，获取通知
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("监听配置：" +  configInfo);
            }
        });
        System.in.read();
    }
}
