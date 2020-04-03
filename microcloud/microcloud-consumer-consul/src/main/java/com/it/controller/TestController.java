package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/04/02 17:36
 */
@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/discoveryClient")
    public Object getDiscoveryClientInfo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("microcloud-provider-consul");
        return instances;
    }

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microcloud-provider-consul");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/dept/1", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }


    @GetMapping
    public String retStr() {
        return "success";
    }

    @RequestMapping("/info/{id}")
    public Object getInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://microcloud-provider-consul/dept/get/" + id, Object.class);
    }
}
