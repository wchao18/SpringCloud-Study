package com.it.controller;

import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;

import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
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

    @RequestMapping(value = "/consumer/dept/get")
    public Object getDept(long id) {
        Dept dept = this.restTemplate.getForObject(DEPT_GET_URL + id,
                Dept.class);
        return dept;
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
