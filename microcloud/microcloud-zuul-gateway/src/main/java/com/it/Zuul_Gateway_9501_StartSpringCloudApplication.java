package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_Gateway_9501_StartSpringCloudApplication {

    /**
     * 1.路由访问地址：http://gateway-9501.com:9501/microcloud-provider-dept/dept/list
     *   这个不配置@EnableEurekaClient和application.yml 也是可以路由访问的,其中的服务名小写的！！！，
     *   注意：一般忽略服务名访问
     * 2.http://gateway-9501.com:9501/it/mydept/proxy/dept/list,这个在application.yml中配置了路由
     *
     * 3.zuul代理了服务的提供者，服务提供者加了springsecurity安全认证,zuul中输入账号密码,无法通过服务提供者的认证！！
     *   因此需要在gateway服务中增加权限的认证,例如AuthorizedFilter和zuulConfig
     *
     * 4.zuul代理的服务提供者挂了，访问zuul的地址报错，其他客户端访问有服务降级的，
     *   因此zuul也要加服务降级处理
     */
    public static void main(String[] args) {
        SpringApplication.run(Zuul_Gateway_9501_StartSpringCloudApplication.class, args);
    }
}
