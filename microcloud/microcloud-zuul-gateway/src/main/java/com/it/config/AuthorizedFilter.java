package com.it.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author wangchao
 * @description zuulfilter的过滤器, 过滤授权访问处理
 * @date 2019/09/03 10:53
 */
public class AuthorizedFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //1.pre:请求发出访问前
        //2.route:路由请求被调用时
        //3.post:路由以后发送请求信息的时候被调用
        //4.error:出现错误被调用
        return "pre";
    }

    @Override
    public int filterOrder() { //过滤器优先级，数字越小，优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() { //改过滤器是否需要执行
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext(); // 获取当前请求的上下文
        String auth = "admin:123456"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}
