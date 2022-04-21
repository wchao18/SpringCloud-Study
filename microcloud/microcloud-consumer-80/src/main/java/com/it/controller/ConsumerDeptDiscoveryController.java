package com.it.controller;

import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 提供方那里加了spring-security安全校验
 */
@RestController
@RequestMapping("/discovery")
public class ConsumerDeptDiscoveryController {
    public static final String APP_NAME = "http://MICROCLOUD-PROVIDER-DEPT";
    public static final String DEPT_GET_URL = APP_NAME + "/dept/get/";
    public static final String DEPT_LIST_URL = APP_NAME + "/dept/list/";
    public static final String DEPT_ADD_URL = APP_NAME + "/dept/add";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discoveryClient")
    public Object getDiscoveryClientInfo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROCLOUD-PROVIDER-DEPT");
        return instances;
    }

    /**
     * 可以测试londbalance策略是否生效
     */
    @RequestMapping(value = "/client")
    public Object client() {
        ServiceInstance choose = loadBalancerClient.choose("MICROCLOUD-PROVIDER-DEPT");
        return choose.getHost() + ":" + choose.getPort();
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        Dept dept = this.restTemplate.exchange(DEPT_GET_URL + id, HttpMethod.GET,
                new HttpEntity<>(httpHeaders), Dept.class).getBody();
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        List<Dept> allDepts = this.restTemplate.exchange(DEPT_LIST_URL,
                HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
        return allDepts;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(@RequestBody Dept dept) {
        Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL
                , HttpMethod.POST, new HttpEntity<>(dept, httpHeaders), Boolean.class).getBody();
        return flag;
    }
}
