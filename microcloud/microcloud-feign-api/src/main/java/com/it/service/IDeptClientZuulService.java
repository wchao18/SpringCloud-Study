package com.it.service;

import com.it.config.FeignClientConfig;
import com.it.config.IDeptClientServiceFallBackFactory;
import com.it.vo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author wangchao
 * @description zuul形式的feign-client,对比IDeptClientService去掉了两项配置，
 *              1.zuul-gateway中加了请求调用方的认证账号密码
 *              2.服务降级配置类重复加载了，暂时去掉！！
 * @date 2019/09/03 11:36
 */
@FeignClient(value = "MICROCLOUD-ZUUL-GATEWAY")
public interface IDeptClientZuulService {

    @RequestMapping(method = RequestMethod.GET, value = "/it/mydept/proxy/dept/get/{id}")
    Dept get(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.GET, value = "/it/mydept/proxy/dept/list")
    List<Dept> list();

    @RequestMapping(method = RequestMethod.POST, value = "/it/mydept/proxy/dept/add")
    boolean add(Dept dept);
}
