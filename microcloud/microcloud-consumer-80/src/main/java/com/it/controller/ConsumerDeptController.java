package com.it.controller;

import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;

import com.it.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerDeptController {
    public static final String DEPT_GET_URL = "http://127.0.0.1:8001/dept/get/";
    public static final String DEPT_LIST_URL = "http://127.0.0.1:8001/dept/list/";
    public static final String DEPT_ADD_URL = "http://127.0.0.1:8001/dept/add";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getDeptFallBack",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        if (id == 4) {
            //被调用服务停止了,这个不受影响
            return "正常访问";
        }
        if (id == 1) {
            throw new RuntimeException("太忙了");
        }
        Dept dept = this.restTemplate.getForObject(DEPT_GET_URL + id,
                Dept.class);
        return dept;
    }

    public Object getDeptFallBack(long id) {
        return "报错了";
    }

    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        List<Dept> allDepts = this.restTemplate.getForObject(DEPT_LIST_URL,
                List.class);
        return allDepts;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(@RequestBody Dept dept) {
        Boolean flag = this.restTemplate.postForObject(DEPT_ADD_URL, dept,
                Boolean.class);
        return flag;
    }
}
